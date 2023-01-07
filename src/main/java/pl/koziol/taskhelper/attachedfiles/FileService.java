package pl.koziol.taskhelper.attachedfiles;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.koziol.taskhelper.Configuration.PathConfig;
import pl.koziol.taskhelper.comment.CommentDataEntity;
import pl.koziol.taskhelper.comment.CommentService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@AllArgsConstructor
public class FileService {

    private AttachedFileInfoService attachedFileInfoService;
    private CommentService commentService;
    PathConfig pathConfig;

    public Resource getFile(Long id) throws MalformedURLException {
        AttachedFileInfoEntity attachedFileInfo = attachedFileInfoService.getAttachedFileInfoById(id);
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

    public void saveFile(MultipartFile newFile, String name, CommentDataEntity commentDataEntity) throws IOException {
        Path path = Path.of(pathConfig.getPath()+name);
        Files.copy(newFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        AttachedFileInfoEntity attachedFileInfo = new AttachedFileInfoEntity();
        attachedFileInfo.setName(name);
        attachedFileInfo.setComment(commentDataEntity);
        attachedFileInfo.setPath(path.toString());
        attachedFileInfo.setSize(Files.size(path));
        attachedFileInfoService.create(attachedFileInfo);
        commentDataEntity.getAttachedFiles().add(attachedFileInfo);
        commentService.update(commentDataEntity);
    }
}
