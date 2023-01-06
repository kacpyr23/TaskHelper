package pl.koziol.taskhelper.attachedfiles;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.koziol.taskhelper.tasks.comment.CommentDataEntity;
import pl.koziol.taskhelper.tasks.comment.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;

import static pl.koziol.taskhelper.TaskhelperApplication.log;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileRestController {

    private FileService fileService;
    private CommentService commentService;
    private AttachedFileInfoService attachedFileInfoService;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable("id") Long id, HttpServletRequest request) throws MalformedURLException {
        Resource resource = fileService.getFile(id);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.error(ex.getMessage());
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
        CommentDataEntity commentDataEntity = commentService.getComment(id);
        if(commentDataEntity == null){
            return;
        }
        fileService.saveFile(file,file.getOriginalFilename(), commentDataEntity);
    }

}
