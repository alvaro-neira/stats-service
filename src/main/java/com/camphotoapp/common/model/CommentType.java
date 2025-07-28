package com.camphotoapp.common.model;

import lombok.Getter;

@Getter
public enum CommentType {
    FEEDBACK(0), //("feedback", "General Feedback"),
    BUG(1), //("bug", "Bug Report"),
    FEATURE(2), //("feature", "Feature Request"),
    SUPPORT(3); //("support", "Support");

    private final int value;

    CommentType(int value) {
        this.value = value;
    }

}