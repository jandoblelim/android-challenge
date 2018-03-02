package com.jandoblelim.androidchallengejanlim.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by devskywalker on 28/10/17.
 */

public class JsonUtility {
    private static ObjectMapper mObjectMapper;

    private static ObjectMapper getObjectMapper() {
        if (mObjectMapper == null) {
            mObjectMapper = new ObjectMapper();
        }

        return mObjectMapper;
    }

    @JsonIgnore
    public static <M> M fromString(String jsonString, Class<M> modelClass) throws IOException {
        return getObjectMapper().readValue(jsonString, modelClass);
    }

    @JsonIgnore
    public static String fromJson(Object object) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(object);
    }

}
