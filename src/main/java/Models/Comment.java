package Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private Long id;
    @Setter
    private String title;
    @Setter
    private String comment;
    private LocalDateTime createdTime;
    private Task task;
}
