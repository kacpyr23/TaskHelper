package pl.koziol.taskhelper.tasks.comment;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.koziol.taskhelper.tasks.task.TaskDataEntity;
import pl.koziol.taskhelper.tasks.task.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentRestController {

    private CommentService commentService;
    private TaskService taskService;

    @GetMapping
    public List<CommentDataEntity> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDataEntity> getComment(@PathVariable("commentId") Long commentId) {
        return Optional
                .ofNullable(commentService.getComment(commentId))
                .map(comment -> ResponseEntity.ok(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<CommentDataEntity>> getCommentsByTask(@PathVariable("taskId") Long taskId){
        if(!taskService.ifExist(taskId)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return Optional
                .ofNullable(commentService.getAllCommentsForTaskByTaskId(taskId))
                .map(comments -> ResponseEntity.ok().body(comments))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/task/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCommentInTask(@PathVariable("taskId") Long taskId, @RequestBody CommentDataEntity commentDataEntity){
        if(!taskService.ifExist(taskId)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        TaskDataEntity taskDataEntity = taskService.getTask(taskId);
        commentDataEntity.setCreatedTime(LocalDateTime.now());
        taskDataEntity.getCommentsList().add(commentDataEntity);
        commentDataEntity.setTask(taskDataEntity);
        Long commentId = commentService.create(commentDataEntity);
        taskService.update(taskDataEntity);
        return new ResponseEntity<>(commentId, HttpStatus.OK);
    }
}
