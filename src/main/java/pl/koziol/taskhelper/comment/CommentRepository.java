package pl.koziol.taskhelper.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentDataEntity, Long> {
    
    List<CommentDataEntity> getCommentDataEntitiesByTaskId(Long taskId);
}
