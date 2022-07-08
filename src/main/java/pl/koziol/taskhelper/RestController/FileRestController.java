package pl.koziol.taskhelper.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.koziol.taskhelper.Models.AttachedFileInfo;
import pl.koziol.taskhelper.Models.Comment;
import pl.koziol.taskhelper.Service.AttachedFileInfoService;
import pl.koziol.taskhelper.Service.CommentService;
import pl.koziol.taskhelper.Service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/file")
public class FileRestController {

    @Autowired
    private FileService fileService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AttachedFileInfoService attachedFileInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable("id") Long id, HttpServletRequest request) throws MalformedURLException {
        Resource resource = fileService.getFile(id);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/comment/{id}")
    public void getFile(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Comment comment = commentService.getComment(id).orElse(null);
        if(comment == null){
            return;
        }
        fileService.saveFile(file,file.getOriginalFilename(),comment);
    }

}
