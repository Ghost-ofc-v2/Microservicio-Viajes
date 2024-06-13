package com.softgr5.microservicio.viajes.DynamoConfig;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public String convert(final LocalDateTime time) {
        return time.format(formatter);
    }


    public LocalDateTime unconvert(final String stringValue) {
        return LocalDateTime.parse(stringValue, formatter);
    }


}
