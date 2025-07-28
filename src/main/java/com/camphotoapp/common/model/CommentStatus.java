package com.camphotoapp.common.model;

import lombok.Getter;

@Getter
public enum CommentStatus {
    NEW(1),
    READ(2);

    private final int value;

    CommentStatus(int value) {
        this.value = value;
    }

    public static CommentStatus fromValue(int value) {
        for (CommentStatus status : CommentStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown CommentStatus value: " + value);
    }
}