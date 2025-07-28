package com.camphotoapp.common.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.Instant;

public class InstantToUnixMillisConverter implements DynamoDBTypeConverter<Long, Instant> {
    @Override
    public Long convert(Instant instant) {
        return instant.toEpochMilli(); // Returns Long
    }

    @Override
    public Instant unconvert(Long epochMillis) {
        return Instant.ofEpochMilli(epochMillis);
    }
}