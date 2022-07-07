package pl.koziol.taskhelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziol.taskhelper.Models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
