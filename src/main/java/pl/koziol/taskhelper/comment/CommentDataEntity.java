package pl.koziol.taskhelper.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.koziol.taskhelper.task.TaskDataEntity;
import pl.koziol.taskhelper.attachedfiles.AttachedFileInfoEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommentDataEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String comment;
    private LocalDateTime createdDate;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "taskId", nullable = false)
    private TaskDataEntity task;
    
    @JsonManagedReference
    @OneToMany
    private List<AttachedFileInfoEntity> attachedFiles;
}
