package com.xproject.master.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xproject.master.app.exception.BaseException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

@Slf4j
@UtilityClass
public class MockLoaderUtils {

    private static final String BASE_PATH = "mocks\\";

    /**
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        ObjectMapper objMapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objMapper.configure(DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES, false);
        objMapper.registerModule(timeModule);
        objMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));

        return objMapper;
    }

    /**
     * @param fileName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getMock(String fileName, Class<T> clazz) {
        ObjectMapper objMapper = getObjectMapper();
        try {
            String fileCompletePath = String.format("%s%s", BASE_PATH, fileName);
            Resource resource = new ClassPathResource(fileCompletePath);
            InputStream inputStream = resource.getInputStream();
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            return objMapper.readValue(reader, clazz);
        } catch (IOException exception) {
            throw new BaseException(exception);
        }
    }

    public static <T> T getMockTypeReference(String fileName, TypeReference<T> typeReference) {
        ObjectMapper objMapper = getObjectMapper();
        Reader reader = null;
        try {
            reader = getReader(fileName);
            return objMapper.readValue(reader, typeReference);
        } catch (IOException exception) {
            throw new BaseException(exception);
        } finally {
            InputStreamReader inputStreamReader = (InputStreamReader) reader;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    log.debug(e.getMessage());
                }
            }
        }
    }

    private static Reader getReader(String fileName) throws IOException {
        String fileCompletePath = String.format("%s%s", BASE_PATH, fileName);
        Resource resource = new ClassPathResource(fileCompletePath);
        InputStream inputStream = resource.getInputStream();
        return new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    }

    public static void printJson(Object obj) {
        ObjectMapper objectMapper = getObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(obj);
            log.info(json);
        } catch (JsonProcessingException e) {
            log.error("Error in convert object to json {}", e.getMessage());
        }
    }

    public static JSONObject getJsonObject(String fileName) {
        try {
            String filePathStr = String.format("%s%s", BASE_PATH, fileName);
            Resource resource = new ClassPathResource(filePathStr);
            filePathStr = resource.getURI().getPath();

            String jsonContent = Files.readString(Path.of(filePathStr.replace("/C:/", "C:/")));

            return new JSONObject(jsonContent);
        } catch (Exception e) {
            return null;
        }
    }
}

