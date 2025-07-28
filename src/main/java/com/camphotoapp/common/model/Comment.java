package com.camphotoapp.common.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

@Data
@DynamoDBTable(tableName = "Comments")
public class Comment {
    @DynamoDBHashKey(attributeName = "commentId")
    private String commentId;

    @DynamoDBAttribute(attributeName = "type")
    @DynamoDBTypeConverted(converter = CommentTypeConverter.class)
    private CommentType type;

    @DynamoDBAttribute(attributeName = "message")
    private String message;

    // Main timestamp as Unix seconds (Number in DynamoDB)
    @DynamoDBRangeKey(attributeName = "timestamp")
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "TimestampIndex")
    @DynamoDBTypeConverted(converter = InstantToUnixMillisConverter.class)
    private Instant timestamp;

    @DynamoDBAttribute(attributeName = "personName")
    private String personName;

    @DynamoDBAttribute(attributeName = "userEmail")
    private String userEmail;

    @DynamoDBAttribute(attributeName = "attachments")
    private List<String> attachments;

    @DynamoDBAttribute(attributeName = "status")
    @DynamoDBTypeConverted(converter = CommentStatusConverter.class)
    private CommentStatus status;

    @DynamoDBAttribute(attributeName = "createdByIp")
    private String createdByIp;

    @DynamoDBAttribute(attributeName = "userAgent")
    private String userAgent;

    // BCP 47 language tag (e.g., "en-US", "es-MX")
    @DynamoDBAttribute(attributeName = "locale")
    @DynamoDBTypeConverted(converter = LocaleConverter.class)
    private Locale locale;
}