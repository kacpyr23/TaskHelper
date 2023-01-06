package pl.koziol.taskhelper.tasks.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskDataEntity, Long> {

    TaskDataEntity getTaskByTaskId(Long taskId);
}
