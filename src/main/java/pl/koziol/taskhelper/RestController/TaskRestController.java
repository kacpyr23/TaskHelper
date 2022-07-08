package pl.koziol.taskhelper.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.koziol.taskhelper.Models.Task;
import pl.koziol.taskhelper.Service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<Task>  getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable("taskId") Long taskId) {
        return taskService.getTask(taskId).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long CreateTask(@RequestBody Task task){
        task.setCreatedDate(LocalDateTime.now());
        return taskService.create(task);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody Task task){
        taskService.update(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }
}
