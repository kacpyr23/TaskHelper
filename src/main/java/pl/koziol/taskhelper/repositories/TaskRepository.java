package pl.koziol.taskhelper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziol.taskhelper.Models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
