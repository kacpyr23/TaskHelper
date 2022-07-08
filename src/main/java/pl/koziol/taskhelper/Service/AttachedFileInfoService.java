package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.Models.AttachedFileInfo;
import pl.koziol.taskhelper.Repositories.AttachedFileInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttachedFileInfoService {

    @Autowired
    private AttachedFileInfoRepository attachedFileInfoRepository;

    public List<AttachedFileInfo> getAllAttachedFilesInfo() {
        return attachedFileInfoRepository.findAll();
    }

    public Optional<AttachedFileInfo> getAttachedFileInfoById(Long AttachedFileInfoId) {
        return attachedFileInfoRepository.getAttachedFileInfoByAttachedFileInfoId(AttachedFileInfoId);
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
