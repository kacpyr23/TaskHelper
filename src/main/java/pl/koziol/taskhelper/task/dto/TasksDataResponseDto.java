package pl.koziol.taskhelper.task.dto;

import lombok.Data;

import java.util.List;

@Data
public class TasksDataResponseDto {

    private List<TaskDataResponseDto> tasks;
}
