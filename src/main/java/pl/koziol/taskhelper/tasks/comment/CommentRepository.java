package pl.koziol.taskhelper.tasks.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentDataEntity, Long> {

    @Query(value = "SELECT * FROM Comment c WHERE c.taskId = :id", nativeQuery = true)
    List<CommentDataEntity> getCommentsByTaskId(@Param("id") Long id);

    CommentDataEntity getCommentByCommentId(Long commentId);
}
