package pl.koziol.taskhelper.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private LocalDateTime createdDate;
    @JsonManagedReference
    @OneToMany(mappedBy = "task")
    private List<Comment> commentsList;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.commentsList = new ArrayList<>();
    }

}
