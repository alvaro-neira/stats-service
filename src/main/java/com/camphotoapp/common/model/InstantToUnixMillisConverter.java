package com.camphotoapp.common.model;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.Instant;

public class InstantToUnixMillisConverter implements AttributeConverter<Instant> {
    @Override
    public AttributeValue transformFrom(Instant input) {
        return input != null ? AttributeValue.builder().n(String.valueOf(input.toEpochMilli())).build() : AttributeValue.builder().nul(true).build();
    }

    @Override
    public Instant transformTo(AttributeValue input) {
        if (input.nul() != null && input.nul()) {
            return null;
        }
        return Instant.ofEpochMilli(Long.parseLong(input.n()));
    }

    @Override
    public EnhancedType<Instant> type() {
        return EnhancedType.of(Instant.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.N;
    }
}