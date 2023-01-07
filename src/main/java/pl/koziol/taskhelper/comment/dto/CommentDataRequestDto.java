package pl.koziol.taskhelper.comment.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentDataRequestDto {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String comment;
}
