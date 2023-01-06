package pl.koziol.taskhelper.tasks.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<TaskDataEntity>  getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDataEntity> getTaskById(@PathVariable("taskId") Long taskId) {
        return Optional
                .ofNullable(taskService.getTask(taskId))
                .map(task -> ResponseEntity.ok().body(task))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createTask(@RequestBody TaskDataEntity taskDataEntity){
        taskDataEntity.setCreatedDate(LocalDateTime.now());
        return taskService.create(taskDataEntity);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody TaskDataEntity taskDataEntity){
        taskService.update(taskDataEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }
}
