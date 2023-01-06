package pl.koziol.taskhelper.tasks.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;

    public List<CommentDataEntity> getAllComments() {
        return commentRepository.findAll();
    }

    public List<CommentDataEntity> getAllCommentsForTaskByTaskId(Long taskId){
        return commentRepository.getCommentsByTaskId(taskId);
    }

    public CommentDataEntity getComment(Long commentId) {
        return commentRepository.getCommentByCommentId(commentId);
    }

    public Long create(CommentDataEntity commentDataEntity){
        return commentRepository.save(commentDataEntity).getCommentId();
    }

    public CommentDataEntity update(CommentDataEntity commentDataEntity){
        return commentRepository.save(commentDataEntity);
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
