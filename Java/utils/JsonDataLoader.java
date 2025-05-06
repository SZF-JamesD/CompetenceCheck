package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataLoader {
    private final ObjectMapper objectMapper;

    public JsonDataLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Map<String, List<Map<String, Object>>> loadData(String path) throws IOException {
        return objectMapper.readValue(new File(path), Map.class);
    }
}
