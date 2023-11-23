import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ZenodoRecordSearch {

    public JsonNode getFirstRecord(String recordName) {
        JsonNode firstHit = null;
        String apiUrl = "https://zenodo.org/api/records/?q=" + recordName;

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);

            HttpResponse response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());

                // Parse the response as JSON using Jackson
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                // Access specific fields if needed
                JsonNode hits = jsonNode.path("hits").path("hits");
                if (hits.size() > 0) {
                    // Process the first hit
                    firstHit = hits.get(0);
                    System.out.println("First hit: " + firstHit);
                } else {
                    System.out.println("No results found for the given record name: " + recordName);
                }
            } else {
                System.err.println("Failed to retrieve Zenodo record. Status code: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Consider logging or rethrowing a custom exception
        }

        return firstHit;
    }
}
