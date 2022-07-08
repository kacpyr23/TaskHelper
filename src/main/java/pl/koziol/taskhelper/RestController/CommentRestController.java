package pl.koziol.taskhelper.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.koziol.taskhelper.Models.Comment;
import pl.koziol.taskhelper.Models.Task;
import pl.koziol.taskhelper.Service.CommentService;
import pl.koziol.taskhelper.Service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable("commentId") Long commentId) {
        return commentService.getComment(commentId).orElse(null);
    }

    @GetMapping("/task/{taskId}")
    public List<Comment> getCommentsByTask(@PathVariable("taskId") Long taskId){
        return (taskService.getTask(taskId).get()).getCommentsList();
    }

    @PostMapping("/task/{taskId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCommentInTask(@PathVariable("taskId") Long taskId, @RequestBody Comment comment){
        comment.setCreatedTime(LocalDateTime.now());
        Task task = taskService.getTask(taskId).isPresent()?taskService.getTask(taskId).get():null;
        if(task == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        task.getCommentsList().add(comment);
        comment.setTask(task);
        Long commentId = commentService.create(comment);
        taskService.update(task);
        return new ResponseEntity<>(commentId, HttpStatus.OK);
    }
}
