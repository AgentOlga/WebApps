package me.ola.webapps2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;


@RequiredArgsConstructor
@Service
public class FileService {

    private final ObjectMapper objectMapper;
    public <T> void saveMapToFile(Map<Long, T> map, Path path) {
        try {
            createNewFile(path);
            String json = objectMapper.writeValueAsString(map);
            Files.writeString(path, json);
        } catch (IOException e) {
           throw  new RuntimeException();
        }
    }
    public <T> Map<Long, T> readMapFromFile(Path path, TypeReference<HashMap<Long, T>> typeReference) {
        try {
            String json = Files.readString(path);
            if (json.isEmpty()) {
                return new HashMap<>();

            }
            return objectMapper.readValue(json, typeReference);
        }
        catch (NoSuchFileException e) {
            return new HashMap<>();
        } catch (IOException e) {
          throw new RuntimeException();
        }

    }
    private void  createNewFile(Path path) throws IOException{
        Files.deleteIfExists(path);
        Files.createFile(path);
    }


    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
