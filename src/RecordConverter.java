import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordConverter {

    public static Record convertJsonNodeToRecord(JsonNode recordNode) {
        // Extract important information
        String id = recordNode.path("id").asText();
        String title = recordNode.path("metadata").path("title").asText();
        String description = recordNode.path("metadata").path("description").asText();

        // Extract more information into a Map
        Map<String, Object> moreInfo = new HashMap<>();
        moreInfo.put("doi", recordNode.path("doi").asText());
        moreInfo.put("created", recordNode.path("created").asText());
        // Add more fields as needed

        List<File> files = new ArrayList<>();
        JsonNode files_json_list = recordNode.path("files");
        for (JsonNode fileNode : files_json_list) {
            File file = FileConverter.convertJsonNodeToFile(fileNode);
            files.add(file);
        }

        // Create a Record instance
        return new Record(id, title, description, moreInfo, files );
    }
}
