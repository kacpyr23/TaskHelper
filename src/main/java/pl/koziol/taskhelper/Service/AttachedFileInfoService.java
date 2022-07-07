package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.Models.AttachedFileInfo;
import pl.koziol.taskhelper.Repositories.AttachedFileInfoRepository;

import java.util.List;

@Service
public class AttachedFileInfoService {

    @Autowired
    private AttachedFileInfoRepository attachedFileInfoRepository;

    public List<AttachedFileInfo> getAllAttachedFilesInfo() {
        return attachedFileInfoRepository.findAll();
    }

    public AttachedFileInfo getAttachedFileInfo(Long id) {
        return attachedFileInfoRepository.getReferenceById(id);
    }

    public Long create(AttachedFileInfo attachedFileInfo){
        return attachedFileInfoRepository.save(attachedFileInfo).getAttachedFileInfoId();
    }

    public AttachedFileInfo update(AttachedFileInfo attachedFileInfo){
        return attachedFileInfoRepository.save(attachedFileInfo);
    }

    public void deleteById(Long id){
        attachedFileInfoRepository.deleteById(id);
    }
}
