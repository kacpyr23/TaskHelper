package pl.koziol.taskhelper.comment;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.koziol.taskhelper.comment.dto.CommentsDataResponseDto;
import pl.koziol.taskhelper.comment.dto.CommentDataRequestDto;
import pl.koziol.taskhelper.comment.dto.CommentDataResponseDto;
import pl.koziol.taskhelper.task.TaskService;
import pl.koziol.taskhelper.task.dto.TaskDataResponseDto;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentRestController {

    private CommentService commentService;
    private TaskService taskService;

    @GetMapping
    public CommentsDataResponseDto getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public CommentDataResponseDto getComment(@PathVariable("commentId") Long commentId) {
        return commentService.getCommentResponse(commentId);
    }

    @GetMapping("/task/{taskId}")
    public CommentsDataResponseDto getCommentsByTask(@PathVariable("taskId") Long taskId){
        return commentService.getAllCommentsForTaskByTaskId(taskId);
    }

    @PostMapping("/task/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDataResponseDto createCommentInTask(@PathVariable("taskId") Long taskId,
        @RequestBody CommentDataRequestDto commentDataRequestDto){
        return taskService.createCommentForTask(taskId, commentDataRequestDto);
    }
}
