package pl.koziol.taskhelper.task;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.koziol.taskhelper.comment.CommentDataEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TaskDataEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private LocalDateTime createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "task")
    private List<CommentDataEntity> comments;

}
