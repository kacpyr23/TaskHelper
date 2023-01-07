package pl.koziol.taskhelper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.koziol.taskhelper.comment.CommentDataMapper;
import pl.koziol.taskhelper.task.dto.CreateTaskDataRequestDto;
import pl.koziol.taskhelper.task.dto.TaskDataResponseDto;

@Mapper(componentModel = "spring", uses = {CommentDataMapper.class})
public interface TaskDataMapper {

    TaskDataEntity mapToTaskDataEntity(CreateTaskDataRequestDto requestDto);

    @Mapping(target = "created", source = "createdDate")
    TaskDataResponseDto mapToTaskDataResponseDto(TaskDataEntity taskData);
}
