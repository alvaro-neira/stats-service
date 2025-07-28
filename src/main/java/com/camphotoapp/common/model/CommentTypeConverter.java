package com.camphotoapp.common.model;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class CommentTypeConverter implements AttributeConverter<CommentType> {
    @Override
    public AttributeValue transformFrom(CommentType input) {
        return input != null ? AttributeValue.builder().s(input.name()).build() : AttributeValue.builder().nul(true).build();
    }

    @Override
    public CommentType transformTo(AttributeValue input) {
        if (input.nul() != null && input.nul()) {
            return null;
        }
        return CommentType.valueOf(input.s());
    }

    @Override
    public EnhancedType<CommentType> type() {
        return EnhancedType.of(CommentType.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }
}
