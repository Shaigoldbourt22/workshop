import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FileConverterTest {

    public static void main(String[] args) {
        testConvertJsonNodeToFile();
    }

    private static void testConvertJsonNodeToFile() {
        // Sample JSON data for testing
        String json = "{\"id\":\"file123\",\"key\":\"sample.txt\",\"size\":1024,\"checksum\":\"md5:abc123\"," +
                "\"links\":{\"self\":\"https://example.com/sample.txt\"}}";

        // Parse JSON string to JsonNode
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);

            // Convert JsonNode to File
            File file = FileConverter.convertJsonNodeToFile(jsonNode);

            // Verify the converted values
            assert file != null;
            assert "file123".equals(file.getId());
            assert "sample.txt".equals(file.getKey());
            assert 1024 == file.getSize();
            assert "md5:abc123".equals(file.getChecksum());
            assert "https://example.com/sample.txt".equals(file.getLinks().getSelf());

            System.out.println("Test passed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Test failed.");
        }
    }
}
