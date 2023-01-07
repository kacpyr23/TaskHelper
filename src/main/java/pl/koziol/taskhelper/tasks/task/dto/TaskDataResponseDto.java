package pl.koziol.taskhelper.tasks.task.dto;

import lombok.Data;
import pl.koziol.taskhelper.comment.dto.CommentDataResponseDto;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDataResponseDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    private List<CommentDataResponseDto> comments;
}
