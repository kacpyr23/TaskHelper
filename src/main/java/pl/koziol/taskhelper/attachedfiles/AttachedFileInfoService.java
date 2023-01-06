package pl.koziol.taskhelper.attachedfiles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttachedFileInfoService {

    private AttachedFileInfoRepository attachedFileInfoRepository;

    public List<AttachedFileInfoEntity> getAllAttachedFilesInfo() {
        return attachedFileInfoRepository.findAll();
    }

    public AttachedFileInfoEntity getAttachedFileInfoById(Long attachedFileInfoId) {
        return attachedFileInfoRepository.getAttachedFileInfoByAttachedFileInfoId(attachedFileInfoId);
    }

    public Long create(AttachedFileInfoEntity attachedFileInfo){
        return attachedFileInfoRepository.save(attachedFileInfo).getAttachedFileInfoId();
    }

    public AttachedFileInfoEntity update(AttachedFileInfoEntity attachedFileInfo){
        return attachedFileInfoRepository.save(attachedFileInfo);
    }

    public void deleteById(Long id){
        attachedFileInfoRepository.deleteById(id);
    }
}
