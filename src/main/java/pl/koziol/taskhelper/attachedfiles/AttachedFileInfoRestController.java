package pl.koziol.taskhelper.attachedfiles;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attachedFile")
@AllArgsConstructor
public class AttachedFileInfoRestController {

    private AttachedFileInfoService attachedFileInfoService;

    @GetMapping()
    public List<AttachedFileInfoEntity> getAllAttachedFilesInfo(){
        return attachedFileInfoService.getAllAttachedFilesInfo();
    }

    @GetMapping("/{attachedFileInfoId}")
    public ResponseEntity<AttachedFileInfoEntity> getAttachedFileById(@PathVariable("attachedFileInfoId") Long attachedFileInfoId) {
        return Optional
                .ofNullable(attachedFileInfoService.getAttachedFileInfoById(attachedFileInfoId))
                .map(attachedFileInfo -> ResponseEntity.ok().body(attachedFileInfo))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
