package pl.koziol.taskhelper.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.comment.dto.CommentDataResponseDto;
import pl.koziol.taskhelper.comment.dto.CommentsDataResponseDto;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
	
	private CommentRepository commentRepository;
	private CommentDataMapper commentDataMapper;
	
	public CommentsDataResponseDto getAllComments() {
		List<CommentDataResponseDto> commentDataResponses = commentRepository.findAll().stream()
			.map(comment -> commentDataMapper.mapToCommentDataResponseDto(comment))
			.toList();
		return CommentsDataResponseDto.builder()
			.comments(commentDataResponses)
			.build();
	}
	
	public CommentsDataResponseDto getAllCommentsForTaskByTaskId(Long taskId) {
		List<CommentDataResponseDto> commentDataResponses = commentRepository.getCommentDataEntitiesByTaskId(taskId)
			.stream()
			.map(comment -> commentDataMapper.mapToCommentDataResponseDto(comment))
			.toList();
		return CommentsDataResponseDto.builder()
			.comments(commentDataResponses)
			.build();
	}
	
	public CommentDataResponseDto getCommentResponse(Long commentId) {
		CommentDataEntity commentData = getCommentDataEntity(commentId);
		return commentDataMapper.mapToCommentDataResponseDto(commentData);
	}
	
	public CommentDataEntity getCommentDataEntity(Long commentId) {
		return commentRepository.findById(commentId)
			.orElseThrow(() -> new EntityNotFoundException("Comment with id %s not found.".formatted(commentId)));
	}
	
	public CommentDataEntity update(CommentDataEntity commentDataEntity) {
		return commentRepository.save(commentDataEntity);
	}
	
	public void deleteById(Long id) {
		commentRepository.deleteById(id);
	}
}
