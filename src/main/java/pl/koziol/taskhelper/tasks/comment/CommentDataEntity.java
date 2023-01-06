package pl.koziol.taskhelper.tasks.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.koziol.taskhelper.tasks.task.TaskDataEntity;
import pl.koziol.taskhelper.attachedfiles.AttachedFileInfoEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommentDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Setter
    private String title;
    @Setter
    private String comment;
    @Setter
    private LocalDateTime createdTime;
    @Setter
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "taskId", nullable = false)
    private TaskDataEntity task;
    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private List<AttachedFileInfoEntity> attachedFilesInfoList;

    public CommentDataEntity(String title, String comment, TaskDataEntity taskDataEntity) {
        this.title = title;
        this.comment = comment;
        this.task = taskDataEntity;
    }
}
