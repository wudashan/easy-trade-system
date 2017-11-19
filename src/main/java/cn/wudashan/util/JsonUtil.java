package cn.wudashan.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author wuzhaofeng
 */
public class JsonUtil {

    private static final JsonUtil INSTANCE = new JsonUtil();

    private ObjectMapper mapper = new ObjectMapper();


    private JsonUtil() {

    }

    public static JsonUtil getInstance() {
        return INSTANCE;
    }

    public String convertObject2JsonString(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public <T> T convertJsonString2Object(String jsonString, Class<T> clazz) throws IOException {
        return mapper.readValue(jsonString, clazz);
    }

}
