package pl.koziol.taskhelper.tasks.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<TaskDataEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    public boolean ifExist(Long taskId){
        return taskRepository.existsById(taskId);
    }

    public TaskDataEntity getTask(Long taskId) {
        return taskRepository.getTaskByTaskId(taskId);
    }

    public Long create(TaskDataEntity taskDataEntity){
        return taskRepository.save(taskDataEntity).getTaskId();
    }

    public TaskDataEntity update(TaskDataEntity taskDataEntity){
        return taskRepository.save(taskDataEntity);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
