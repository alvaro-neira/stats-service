package com.camphotoapp.common.model;

import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

@Setter
@DynamoDbBean
public class Comment {
    private String commentId;
    private CommentType type;
    private String message;
    private Instant timestamp;
    private String personName;
    private String userEmail;
    private List<String> attachments;
    private CommentStatus status;
    private String createdByIp;
    private String userAgent;
    private Locale locale;

    public Comment() {}

    @DynamoDbPartitionKey
    public String getCommentId() {
        return commentId;
    }

    @DynamoDbAttribute("type")
    @DynamoDbConvertedBy(CommentTypeConverter.class)
    public CommentType getType() {
        return type;
    }

    @DynamoDbAttribute("message")
    public String getMessage() {
        return message;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("timestamp")
    @DynamoDbConvertedBy(InstantToUnixMillisConverter.class)
    public Instant getTimestamp() {
        return timestamp;
    }

    @DynamoDbAttribute("personName")
    public String getPersonName() {
        return personName;
    }

    @DynamoDbAttribute("userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    @DynamoDbAttribute("attachments")
    public List<String> getAttachments() {
        return attachments;
    }

    @DynamoDbAttribute("status")
    @DynamoDbConvertedBy(CommentStatusConverter.class)
    public CommentStatus getStatus() {
        return status;
    }

    @DynamoDbAttribute("createdByIp")
    public String getCreatedByIp() {
        return createdByIp;
    }

    @DynamoDbAttribute("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    @DynamoDbAttribute("locale")
    @DynamoDbConvertedBy(LocaleConverter.class)
    public Locale getLocale() {
        return locale;
    }

}