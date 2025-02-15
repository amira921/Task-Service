package com.microservices.todo.dto;

import com.microservices.todo.common.enums.TaskCategory;
import com.microservices.todo.common.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {
    private Long taskId;
    private String userEmail;
    private String title;
    private String description;
    private TaskCategory taskCategory;
    private LocalDateTime dueDate;
    private TaskStatus taskStatus;
}