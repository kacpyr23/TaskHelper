package pl.koziol.taskhelper.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.comment.CommentDataEntity;
import pl.koziol.taskhelper.comment.CommentDataMapper;
import pl.koziol.taskhelper.comment.CommentService;
import pl.koziol.taskhelper.comment.dto.CommentDataRequestDto;
import pl.koziol.taskhelper.task.dto.CreateTaskDataRequestDto;
import pl.koziol.taskhelper.task.dto.TaskDataRequestDto;
import pl.koziol.taskhelper.task.dto.TaskDataResponseDto;
import pl.koziol.taskhelper.task.dto.TasksDataResponseDto;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    private TaskDataMapper taskDataMapper;
    
    private CommentDataMapper commentDataMapper;
    
    private CommentService commentService;

    public TasksDataResponseDto getAllTasks() {
        List<TaskDataResponseDto> tasksResponses = taskRepository.findAll().stream()
                .map(task -> taskDataMapper.mapToTaskDataResponseDto(task))
                .toList();
        TasksDataResponseDto tasksDataResponseDto = new TasksDataResponseDto();
        tasksDataResponseDto.setTasks(tasksResponses);
        return tasksDataResponseDto;
    }

    public boolean ifExist(Long taskId){
        return taskRepository.existsById(taskId);
    }

    public TaskDataEntity getTask(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task with id %s not found.".formatted(taskId)));
    }

    public TaskDataResponseDto create(CreateTaskDataRequestDto taskDataRequest){
        TaskDataEntity taskData = taskDataMapper.mapToTaskDataEntity(taskDataRequest);
        taskData.setCreatedDate(LocalDateTime.now());
        taskData.setComments(new ArrayList<>());
        taskData = taskRepository.save(taskData);
        return taskDataMapper.mapToTaskDataResponseDto(taskData);
    }

    public TaskDataResponseDto update(Long taskId, TaskDataRequestDto taskDataRequest){
        TaskDataEntity taskData = getTask(taskId);
        taskData.setName(taskDataRequest.getName());
        taskData.setDescription(taskDataRequest.getDescription());
        taskData = taskRepository.save(taskData);
        return taskDataMapper.mapToTaskDataResponseDto(taskData);
    }
    
    public TaskDataEntity updateTaskDataWithComments(TaskDataEntity taskDataEntity) {
        return taskRepository.save(taskDataEntity);
    }
    
    public TaskDataResponseDto createCommentForTask(Long taskId, CommentDataRequestDto commentDataRequestDto) {
        TaskDataEntity taskData = getTask(taskId);
        CommentDataEntity commentData = commentDataMapper.mapToCommentDataEntity(commentDataRequestDto);
        commentData.setCreatedDate(LocalDateTime.now());
        commentData.setTask(taskData);
        commentService.update(commentData);
        taskData = getTask(taskId);
        return taskDataMapper.mapToTaskDataResponseDto(taskData);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
}
