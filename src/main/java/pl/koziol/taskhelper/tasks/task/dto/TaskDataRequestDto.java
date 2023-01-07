package pl.koziol.taskhelper.tasks.task.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskDataRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
