package pl.koziol.taskhelper.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachedFileId;
    private String name;
    private Long size;
    private String path;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private Comment comment;

}
