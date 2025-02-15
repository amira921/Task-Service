package com.microservices.todo.service.impl;

import com.microservices.todo.common.enums.ApiStatus;
import com.microservices.todo.dto.TaskDTO;
import com.microservices.todo.common.enums.TaskType;
import com.microservices.todo.dto.payload.request.TaskRequest;
import com.microservices.todo.dto.payload.request.UpdateTaskRequest;
import com.microservices.todo.dto.payload.response.ApiResponse;
import com.microservices.todo.service.TaskService;
import com.microservices.todo.util.MessageUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final MessageUtil messageUtil;

    @Override
    public ApiResponse<TaskDTO> addTask(String email, TaskRequest task, ServerWebExchange exchange) {
        return ApiResponse.<TaskDTO>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(TaskDTO.builder().build())
                .build();
    }

    @Override
    public ApiResponse<TaskDTO> updateTask(String email, long taskId,
                                           UpdateTaskRequest taskDTO, ServerWebExchange exchange) {
        return ApiResponse.<TaskDTO>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).build();
    }

    @Override
    public ApiResponse<TaskDTO> deleteTaskByTaskIdAndUserEmail(String email, long taskId, ServerWebExchange exchange) {
        return ApiResponse.<TaskDTO>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(TaskDTO.builder().build())
                .build();
    }

    @Override
    public ApiResponse<List<TaskDTO>> getTasksByUserEmailAndTaskType(String email, TaskType type, ServerWebExchange exchange) {
        return ApiResponse.<List<TaskDTO>>builder()
                .timestamp(Timestamp.from(Instant.now()))
                .path(exchange.getRequest().getPath().toString())
                .status(ApiStatus.SUCCESS.getCode())
                .success(true)
                .message(messageUtil.getMessage(ApiStatus.SUCCESS.getMessageKey(),
                        exchange.getRequest().getPath().toString())
                ).data(new ArrayList<TaskDTO>())
                .build();
    }
}