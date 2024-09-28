package com.htd.sample.converter;

import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: retrofit-root
 * Create By: Chen.F.X
 * DateTime: 2024-09-28 11:28
 * <p>
 * Desc: 自定义日期类型转换
 */
public class DateConverter implements Converter<Date, String> {
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Nullable
    @Override
    public String convert(Date value) throws IOException {
        return SIMPLE_DATE_FORMAT.format(value);
    }

    public static class DateConverterFactory extends Converter.Factory {
        @Nullable
        @Override
        public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            if (type == Date.class) {
                return new DateConverter();
            }
            return super.stringConverter(type, annotations, retrofit);
        }

        public static Converter.Factory create() {
            return new DateConverterFactory();
        }
    }
}



