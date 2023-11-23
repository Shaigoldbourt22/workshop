import com.fasterxml.jackson.databind.JsonNode;

public class FileConverter {

    public static File convertJsonNodeToFile(JsonNode fileNode) {
        String id = fileNode.path("id").asText();
        String key = fileNode.path("key").asText();
        long size = fileNode.path("size").asLong();
        String checksum = fileNode.path("checksum").asText();

        JsonNode linksNode = fileNode.path("links");
        String selfLink = linksNode.path("self").asText();

        File.Links links = new File.Links(selfLink);

        return new File(id, key, size, checksum, links);
    }
}
