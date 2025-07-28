package com.camphotoapp.common.model;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class CommentStatusConverter implements AttributeConverter<CommentStatus> {

    @Override
    public AttributeValue transformFrom(CommentStatus input) {
        return input != null ? AttributeValue.builder().n(String.valueOf(input.getValue())).build() : AttributeValue.builder().nul(true).build();
    }

    @Override
    public CommentStatus transformTo(AttributeValue input) {
        if (input.nul() != null && input.nul()) {
            return null;
        }
        return CommentStatus.fromValue(Integer.parseInt(input.n()));
    }

    @Override
    public EnhancedType<CommentStatus> type() {
        return EnhancedType.of(CommentStatus.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.N;
    }
}