package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Comment {
    private Long id;
    @Setter
    private String title;
    @Setter
    private String comment;
    private LocalDateTime createdTime;
    private Task task;

    public Comment(String title, String comment, Task task) {
        this.title = title;
        this.comment = comment;
        this.task = task;
        this.createdTime = LocalDateTime.now();
    }
}
