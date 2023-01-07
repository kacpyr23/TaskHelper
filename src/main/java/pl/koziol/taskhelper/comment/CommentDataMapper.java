package pl.koziol.taskhelper.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.koziol.taskhelper.comment.dto.CommentDataRequestDto;
import pl.koziol.taskhelper.comment.dto.CommentDataResponseDto;

@Mapper(componentModel = "spring")
public interface CommentDataMapper {
	
	CommentDataEntity mapToCommentDataEntity(CommentDataRequestDto requestDto);
	
	@Mapping(target = "created", source = "createdDate")
	CommentDataResponseDto mapToCommentDataResponseDto(CommentDataEntity commentDataEntity);
}
