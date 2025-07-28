package com.camphotoapp.common.model;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Locale;

public class LocaleConverter implements AttributeConverter<Locale> {
    @Override
    public AttributeValue transformFrom(Locale input) {
        return input != null ? AttributeValue.builder().s(input.toLanguageTag()).build() : AttributeValue.builder().nul(true).build();
    }

    @Override
    public Locale transformTo(AttributeValue input) {
        if (input.nul() != null && input.nul()) {
            return null;
        }
        return Locale.forLanguageTag(input.s());
    }

    @Override
    public EnhancedType<Locale> type() {
        return EnhancedType.of(Locale.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }
}
