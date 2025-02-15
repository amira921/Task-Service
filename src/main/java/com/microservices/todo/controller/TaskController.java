package com.microservices.todo.controller;

import com.microservices.todo.common.enums.TaskType;
import com.microservices.todo.dto.payload.request.TaskRequest;
import com.microservices.todo.dto.payload.request.UpdateTaskRequest;
import com.microservices.todo.dto.payload.response.ApiResponse;
import com.microservices.todo.service.TaskService;
import com.microservices.todo.validation.annotation.ValidEmail;
import com.microservices.todo.validation.annotation.ValidTaskId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/todo/{userEmail}")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public Mono<ResponseEntity<ApiResponse>> getTasks(@ValidEmail @PathVariable String userEmail,
                                                      ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=personal")
    public Mono<ResponseEntity<ApiResponse>> getPersonalTasks(@ValidEmail @PathVariable String userEmail,
                                                              ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=work")
    public Mono<ResponseEntity<ApiResponse>> getWorkTasks(@ValidEmail @PathVariable String userEmail,
                                                          ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=today")
    public Mono<ResponseEntity<ApiResponse>> getTodayTasks(@ValidEmail @PathVariable String userEmail,
                                                           ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=next-week")
    public Mono<ResponseEntity<ApiResponse>> getWeeklyTasks(@ValidEmail @PathVariable String userEmail,
                                                            ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=todo")
    public Mono<ResponseEntity<ApiResponse>> getTodoTasks(@ValidEmail @PathVariable String userEmail,
                                                          ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.NO_TYPE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=in-progress")
    public Mono<ResponseEntity<ApiResponse>> getInProgressTasks(@ValidEmail @PathVariable String userEmail,
                                                                ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.IN_PROGRESS, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=completed")
    public Mono<ResponseEntity<ApiResponse>> getCompletedTasks(@ValidEmail @PathVariable String userEmail,
                                                               ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.COMPLETED, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=overdue")
    public Mono<ResponseEntity<ApiResponse>> getOverdueTasks(@ValidEmail @PathVariable String userEmail,
                                                             ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.OVER_DUE, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping("/filter=due-soon")
    public Mono<ResponseEntity<ApiResponse>> getDueSoonTasks(@ValidEmail @PathVariable String userEmail,
                                                             ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.getTasksByUserEmailAndTaskType(userEmail, TaskType.DUE_SOON, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @PostMapping("/add-task")
    public Mono<ResponseEntity<ApiResponse>> createTask(@ValidEmail @PathVariable String userEmail,
                                                        @Valid @RequestBody TaskRequest newTask,
                                                        ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.addTask(userEmail, newTask, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @PostMapping("/update-task/{taskId}")
    public Mono<ResponseEntity<ApiResponse>> updateTask(@ValidEmail @PathVariable String userEmail,
                                                        @ValidTaskId @PathVariable long taskId,
                                                        @Valid @RequestBody UpdateTaskRequest task,
                                                        ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.updateTask(userEmail, taskId, task, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }

    @GetMapping ("/delete-task/{taskId}")
    public Mono<ResponseEntity<ApiResponse>> deleteTask(@ValidEmail @PathVariable  String userEmail,
                                                        @ValidTaskId @PathVariable long taskId,
                                                        ServerWebExchange exchange) {
        return Mono.fromCallable(() -> {
            ApiResponse response = taskService.deleteTaskByTaskIdAndUserEmail(userEmail, taskId, exchange);
            return ResponseEntity.status(response.getStatus()).body(response);
        });
    }
}