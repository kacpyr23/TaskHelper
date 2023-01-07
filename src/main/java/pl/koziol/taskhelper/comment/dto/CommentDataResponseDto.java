package pl.koziol.taskhelper.comment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDataResponseDto {
	
	private Long id;
	private String title;
	private String comment;
	private LocalDateTime created;
}
