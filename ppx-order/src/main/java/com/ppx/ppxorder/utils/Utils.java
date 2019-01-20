package com.ppx.ppxorder.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class Utils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> String bean2json(T bean) {
        try {
            return mapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "can't parse json";
        }
    }

    public static boolean isJava8() {
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.contains("1.8")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getIpAddr(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
