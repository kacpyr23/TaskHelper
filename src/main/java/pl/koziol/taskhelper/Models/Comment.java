package pl.koziol.taskhelper.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Setter
    private String title;
    @Setter
    private String comment;
    @CreatedDate
    private LocalDateTime createdTime;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "taskId", nullable = false)
    private Task task;
    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private List<AttachedFile> attachedFilesList;

    public Comment(String title, String comment, Task task) {
        this.title = title;
        this.comment = comment;
        this.task = task;
    }
}
