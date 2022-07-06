package Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachedFile {
    private String name;
    private Long size;
    private String path;
    private Comment comment;
}
