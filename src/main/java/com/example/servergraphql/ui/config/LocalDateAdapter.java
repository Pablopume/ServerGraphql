package com.example.servergraphql.ui.config;


import graphql.scalars.ExtendedScalars;
import graphql.schema.*;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import graphql.language.StringValue;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.format.DateTimeParseException;
public class LocalDateAdapter {
    public static final GraphQLScalarType LOCAL_DATE = GraphQLScalarType.newScalar()
            .name(Constantes.LOCAL_DATE1)
            .description(Constantes.A_CUSTOM_SCALAR_THAT_HANDLES_LOCAL_DATE_VALUES)
            .coercing(new Coercing<LocalDate, String>() {
                @Override
                public String serialize(Object dataFetcherResult) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constantes.YYYY_MM_DD);
                    return formatter.format((LocalDate) dataFetcherResult);
                }

                @Override
                public LocalDate parseValue(Object input) {
                    if (input instanceof String) {
                        return LocalDate.parse((String) input, DateTimeFormatter.ofPattern(Constantes.YYYY_MM_DD));
                    } else {
                        throw new IllegalArgumentException(Constantes.INVALID_INPUT_FOR_LOCAL_DATE);
                    }
                }

                @Override
                public LocalDate parseLiteral(Object input) {
                    if (input instanceof StringValue) {
                        return parseValue(((StringValue) input).getValue());
                    } else {
                        throw new IllegalArgumentException(Constantes.INVALID_INPUT_FOR_LOCAL_DATE);
                    }
                }
            }).build();


}
