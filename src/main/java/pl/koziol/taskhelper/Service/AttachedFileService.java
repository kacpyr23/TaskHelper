package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.Models.AttachedFile;
import pl.koziol.taskhelper.Models.Task;
import pl.koziol.taskhelper.Repositories.AttachedFileRepository;
import pl.koziol.taskhelper.Repositories.TaskRepository;

import java.util.List;

@Service
public class AttachedFileService {

    @Autowired
    private AttachedFileRepository attachedFileRepository;

    public List<AttachedFile> getAllAttachedFiles() {
        return attachedFileRepository.findAll();
    }

    public AttachedFile getAttachedFile(Long id) {
        return attachedFileRepository.getReferenceById(id);
    }

    public Long create(AttachedFile attachedFile){
        return attachedFileRepository.save(attachedFile).getAttachedFileId();
    }

    public AttachedFile update(AttachedFile attachedFile){
        return attachedFileRepository.save(attachedFile);
    }

    public void deleteById(Long id){
        attachedFileRepository.deleteById(id);
    }
}
