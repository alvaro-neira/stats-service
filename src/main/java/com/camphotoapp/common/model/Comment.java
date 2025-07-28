package com.camphotoapp.common.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

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

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    @DynamoDbAttribute("type")
    @DynamoDbConvertedBy(CommentTypeConverter.class)
    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }

    @DynamoDbAttribute("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("timestamp")
    @DynamoDbConvertedBy(InstantToUnixMillisConverter.class)
    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @DynamoDbAttribute("personName")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @DynamoDbAttribute("userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @DynamoDbAttribute("attachments")
    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    @DynamoDbAttribute("status")
    @DynamoDbConvertedBy(CommentStatusConverter.class)
    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    @DynamoDbAttribute("createdByIp")
    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @DynamoDbAttribute("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @DynamoDbAttribute("locale")
    @DynamoDbConvertedBy(LocaleConverter.class)
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}