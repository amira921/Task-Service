package com.microservices.todo.common.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TaskType {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    DUE_SOON("Due Soon"),
    OVER_DUE("Overdue"),
    NO_TYPE("No Type"),
    TODAY("Today"),
    NEXT_WEEK("Next Week"),
    PERSONAL("Personal"),
    WORK("Work");

    private final String value;
}
