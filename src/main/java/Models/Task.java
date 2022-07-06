package Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Task {
    private Long id;
    @Setter
    private String name;
    @Setter
    private String description;
    private LocalDateTime createdDate;
    private List<Comment> commentsList;
}
