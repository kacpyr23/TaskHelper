package pl.koziol.taskhelper.tasks.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.koziol.taskhelper.tasks.task.dto.CreateTaskDataRequestDto;
import pl.koziol.taskhelper.tasks.task.dto.TaskDataResponseDto;

@Mapper(componentModel = "spring")
public interface TaskDataMapper {

    TaskDataEntity mapToTaskDataEntity(CreateTaskDataRequestDto requestDto);

    @Mapping(target = "created", source = "createdDate")
    TaskDataResponseDto mapToTaskDataResponseDto(TaskDataEntity taskData);
}
