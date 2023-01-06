package pl.koziol.taskhelper.tasks.task;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.koziol.taskhelper.tasks.comment.CommentDataEntity;

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
public class TaskDataEntity {
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
    private List<CommentDataEntity> commentsList;

    public TaskDataEntity(String name, String description) {
        this.name = name;
        this.description = description;
        this.commentsList = new ArrayList<>();
    }

}
