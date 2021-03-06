package pl.koziol.taskhelper.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.Models.Comment;
import pl.koziol.taskhelper.Repositories.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentsForTaskByTaskId(Long taskId){
        return commentRepository.getCommentsByTaskId(taskId);
    }

    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.getCommentByCommentId(commentId);
    }

    public Long create(Comment comment){
        return commentRepository.save(comment).getCommentId();
    }

    public Comment update(Comment comment){
        return commentRepository.save(comment);
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
