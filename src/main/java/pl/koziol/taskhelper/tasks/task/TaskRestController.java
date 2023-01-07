package pl.koziol.taskhelper.tasks.task;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.koziol.taskhelper.tasks.task.dto.CreateTaskDataRequestDto;
import pl.koziol.taskhelper.tasks.task.dto.TaskDataRequestDto;
import pl.koziol.taskhelper.tasks.task.dto.TaskDataResponseDto;
import pl.koziol.taskhelper.tasks.task.dto.TasksDataResponseDto;

import java.util.Optional;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskRestController {
	
	private TaskService taskService;
	
	@GetMapping()
	public TasksDataResponseDto getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<TaskDataEntity> getTaskById(@PathVariable("taskId") Long taskId) {
		return Optional.ofNullable(taskService.getTask(taskId)).map(task -> ResponseEntity.ok().body(task)).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskDataResponseDto createTask(@RequestBody CreateTaskDataRequestDto taskDataEntity) {
		return taskService.create(taskDataEntity);
	}
	
	@PutMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public TaskDataResponseDto updateTask(@PathVariable("taskId") Long taskId,
		@RequestBody TaskDataRequestDto taskDataRequest) {
		return taskService.update(taskId, taskDataRequest);
	}
	
	@DeleteMapping("/{taskId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTaskById(@PathVariable("taskId") Long id) {
		taskService.deleteById(id);
	}
}
