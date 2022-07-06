package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Task {
    private Long id;
    @Setter
    private String name;
    @Setter
    private String description;
    private LocalDateTime createdDate;
    private List<Comment> commentsList;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.commentsList = new ArrayList<>();
    }
}
