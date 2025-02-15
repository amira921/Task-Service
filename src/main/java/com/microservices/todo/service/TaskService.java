package com.microservices.todo.service;

import com.microservices.todo.dto.TaskDTO;
import com.microservices.todo.common.enums.TaskType;
import com.microservices.todo.dto.payload.request.TaskRequest;
import com.microservices.todo.dto.payload.request.UpdateTaskRequest;
import com.microservices.todo.dto.payload.response.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Service
public interface TaskService {
    ApiResponse<List<TaskDTO>> getTasksByUserEmailAndTaskType(String email,
                                                              TaskType type,
                                                              ServerWebExchange exchange);
    ApiResponse<TaskDTO> addTask(String email,
                                 TaskRequest task,
                                 ServerWebExchange exchange);
    ApiResponse<TaskDTO> updateTask(String email,
                                    long taskId,
                                    UpdateTaskRequest taskDTO,
                                    ServerWebExchange exchange);
    ApiResponse<TaskDTO> deleteTaskByTaskIdAndUserEmail(String email,
                                                        long taskId,
                                                        ServerWebExchange exchange);
}