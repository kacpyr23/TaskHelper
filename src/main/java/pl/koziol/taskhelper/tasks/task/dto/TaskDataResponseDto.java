package pl.koziol.taskhelper.tasks.task.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDataResponseDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
}
