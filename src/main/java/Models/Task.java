package Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Task {
    private Long id;
    @Setter
    private String name;
    @Setter
    private String description;
    private LocalDateTime createdDate;
}
