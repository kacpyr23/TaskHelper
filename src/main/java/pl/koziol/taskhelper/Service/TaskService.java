package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.Models.Task;
import pl.koziol.taskhelper.Repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.getReferenceById(id);
    }

    public Long create(Task task){
        return taskRepository.save(task).getTaskId();
    }

    public Task update(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
