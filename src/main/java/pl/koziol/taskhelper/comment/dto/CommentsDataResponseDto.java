package pl.koziol.taskhelper.comment.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommentsDataResponseDto {
	
	private List<CommentDataResponseDto> comments;
}
