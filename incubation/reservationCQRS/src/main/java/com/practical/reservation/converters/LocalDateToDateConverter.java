package com.practical.reservation.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

@Component
@ReadingConverter
public class LocalDateToDateConverter implements Converter<LocalDate, Date> {
    @Override
    public Date convert(LocalDate localDate) {
        return new Date(localDate.atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli());
    }

}
