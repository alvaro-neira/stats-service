package com.camphotoapp.common.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.Locale;

// Locale Converter
public class LocaleConverter implements DynamoDBTypeConverter<String, Locale> {
    @Override
    public String convert(Locale locale) {
        return locale.toLanguageTag(); // "en-US", "es-ES", etc.
    }

    @Override
    public Locale unconvert(String languageTag) {
        return Locale.forLanguageTag(languageTag);
    }
}
