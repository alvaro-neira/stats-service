package com.camphotoapp.common.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

// Locale Converter
public class CommentTypeConverter implements DynamoDBTypeConverter<String, CommentType> {
    @Override
    public String convert(CommentType commentType) {
        return commentType.name();
    }

    @Override
    public CommentType unconvert(String cType) {
        return CommentType.valueOf(cType);
    }
}
