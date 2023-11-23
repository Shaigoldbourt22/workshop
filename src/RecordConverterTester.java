import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.SQLOutput;

public class RecordConverterTester {

    public static void main(String[] args) {
        // Example JSON representing a Zenodo record
        String json = "{\n" +
                "  \"id\": \"123\",\n" +
                "  \"metadata\": {\n" +
                "    \"title\": \"Sample Title\",\n" +
                "    \"description\": \"Sample Description\"\n" +
                "  },\n" +
                "  \"doi\": \"https://doi.org/10.1234/zenodo.123\",\n" +
                "  \"created\": \"2023-07-13T11:13:12.257127+00:00\"\n" +
                "}";

        // Parse the JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);

            // Use the RecordConverter to convert JsonNode to Record
            Record record = RecordConverter.convertJsonNodeToRecord(jsonNode);

            // Print the converted Record
            System.out.println("Converted Record:");
            System.out.println("ID: " + record.getId());
            System.out.println("Title: " + record.getTitle());
            System.out.println("Description: " + record.getDescription());
            System.out.println("More Info: " + record.getMoreInfo());
            System.out.println(record.getFiles());
            System.out.println(record.getMoreInfo().get("created"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
