package pl.koziol.taskhelper.attachedfiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.koziol.taskhelper.comment.CommentDataEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachedFileInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachedFileInfoId;
    private String name;
    private Long size;
    private String path;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private CommentDataEntity comment;

}
