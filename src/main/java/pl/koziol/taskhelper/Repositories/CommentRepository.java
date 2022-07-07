package pl.koziol.taskhelper.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.koziol.taskhelper.Models.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM Comment c WHERE c.taskId = :id", nativeQuery = true)
    public List<Comment> getCommentsByTaskId(@Param("id") Long id);
}
