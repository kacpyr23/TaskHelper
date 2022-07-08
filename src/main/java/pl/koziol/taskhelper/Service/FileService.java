package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.koziol.taskhelper.Configuration.PathConfig;
import pl.koziol.taskhelper.Models.AttachedFileInfo;
import pl.koziol.taskhelper.Models.Comment;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Autowired
    private AttachedFileInfoService attachedFileInfoService;

    @Autowired
    private CommentService commentService;

    @Autowired
    PathConfig pathConfig;

    public Resource getFile(Long id) throws MalformedURLException {
        AttachedFileInfo attachedFileInfo = attachedFileInfoService.getAttachedFileInfoById(id).isPresent()?attachedFileInfoService.getAttachedFileInfoById(id).get():null;
        if(attachedFileInfo==null){
            return null;
        }
        File file = new File(attachedFileInfo.getPath());
        Resource resource = new UrlResource(file.getAbsoluteFile().toURI());
        if(resource.exists()) {
            return resource;
        }else {
            return null;
        }
    }

    public void saveFile(MultipartFile newFile, String name, Comment comment) throws IOException {
        Path path = Path.of(pathConfig.getPath()+name);
        Files.copy(newFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        AttachedFileInfo attachedFileInfo = new AttachedFileInfo();
        attachedFileInfo.setName(name);
        attachedFileInfo.setComment(comment);
        attachedFileInfo.setPath(path.toString());
        attachedFileInfo.setSize(Files.size(path));
        attachedFileInfoService.create(attachedFileInfo);
        comment.getAttachedFilesInfoList().add(attachedFileInfo);
        commentService.update(comment);
    }
}
