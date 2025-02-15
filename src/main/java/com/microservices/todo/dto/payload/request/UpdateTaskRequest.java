package com.microservices.todo.dto.payload.request;

import com.microservices.todo.common.enums.TaskCategory;
import com.microservices.todo.common.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
@Builder
public class UpdateTaskRequest {
    @NotBlank(message = "Please enter a title")
    private String title;

    @NotBlank(message = "Please enter a description")
    private String description;

    @NotNull(message = "Please choose a category\n" +
            "1.Personal\n" +
            "2.Work\n"
    )
    private TaskCategory taskCategory;

    @NotNull(message = "Please enter a due date for the task")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;

    @NotNull(message = "Please enter a valid Task Status:\n" +
            "1. TODO\n" +
            "2. IN_PROGRESS\n" +
            "3. COMPLETED\n" +
            "4. DUE_SOON\n" +
            "5. OVER_DUE\n" +
            "6. NO_TYPE\n" +
            "7. TODAY\n" +
            "8. NEXT_WEEK\n"
    )
    private TaskStatus taskStatus;
}
