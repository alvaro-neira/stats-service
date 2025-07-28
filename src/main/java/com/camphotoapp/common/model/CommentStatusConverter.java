package com.camphotoapp.common.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class CommentStatusConverter implements DynamoDBTypeConverter<Integer, CommentStatus> {

    @Override
    public Integer convert(CommentStatus status) {
        return status != null ? status.getValue() : null;
    }

    @Override
    public CommentStatus unconvert(Integer statusValue) {
        return statusValue != null ? CommentStatus.fromValue(statusValue) : null;
    }
}