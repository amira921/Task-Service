package com.microservices.todo.dto.payload.request;

import com.microservices.todo.common.enums.TaskCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskRequest {
    @NotBlank(message = "Please enter a title")
    private String title;

    @NotBlank(message = "Please enter a description")
    private String description;

    @NotNull(message = "Please enter a valid Task Category:\n" +
            "1. Work\n" +
            "2. Personal\n"
    )
    private TaskCategory taskCategory;

    @NotNull(message = "Please enter a due date for the task")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
}
