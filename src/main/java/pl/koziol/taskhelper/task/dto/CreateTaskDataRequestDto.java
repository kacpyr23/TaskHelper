package pl.koziol.taskhelper.task.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTaskDataRequestDto {

    @NotBlank
    private String name;

    private String description;
}
