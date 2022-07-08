package pl.koziol.taskhelper.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.koziol.taskhelper.Models.AttachedFileInfo;
import pl.koziol.taskhelper.Service.AttachedFileInfoService;

import java.util.List;

@RestController
@RequestMapping("/attachedFile")
public class AttachedFileInfoRestController {

    @Autowired
    private AttachedFileInfoService attachedFileInfoService;

    @GetMapping()
    public List<AttachedFileInfo> getAllAttachedFilesInfo(){
        return attachedFileInfoService.getAllAttachedFilesInfo();
    }

    @GetMapping("/{attachedFileInfoId}")
    public AttachedFileInfo getAttachedFileById(@PathVariable("attachedFileInfoId") Long attachedFileInfoId) {
        return attachedFileInfoService.getAttachedFileInfoById(attachedFileInfoId).orElse(null);
    }


}
