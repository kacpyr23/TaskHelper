package pl.koziol.taskhelper.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskDataEntity, Long> {

}
