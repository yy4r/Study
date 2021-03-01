package com.example.base.myProcessor.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 * @author luohuan
 */
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static String toJsonString(Object o) throws JsonProcessingException {
            return OBJECT_MAPPER.writeValueAsString(o);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws JsonProcessingException {
            return OBJECT_MAPPER.readValue(json, clazz);
    }

    public static <T> T toObject(String json, TypeReference<T> type) throws JsonProcessingException {
            return OBJECT_MAPPER.readValue(json, type);
    }

}
