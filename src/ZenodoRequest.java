// Importing necessary classes and packages for the ZenodoRequest class
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.classic.methods.multipart.MultipartEntityBuilder;
import org.apache.hc.client5.http.classic.methods.multipart.entity.FileBody;
import org.apache.hc.client5.http.classic.methods.multipart.entity.StringBody;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Definition of the ZenodoRequest class
public class ZenodoRequest {

    // Base URL for Zenodo API
    private static final String BASE_URL = "https://zenodo.org/api";
    // Sandbox URL for testing purposes
    private static final String SANDBOX_URL = "http://sandbox.zenodo.org/api"; // Sandbox URL

    // ObjectMapper for handling JSON
    private final ObjectMapper objectMapper;
    // Access token for Zenodo API authentication
    private final String accessToken;
    // Flag to indicate whether to use the sandbox environment
    private final boolean useSandbox;

    // Constructor with an additional parameter for sandbox flag
    public ZenodoRequest(String accessToken, boolean useSandbox) {
        this.objectMapper = new ObjectMapper();
        this.accessToken = accessToken;
        this.useSandbox = useSandbox;
    }

    // Common method for sending HTTP requests
    private JsonNode sendRequest(HttpUriRequestBase request) throws IOException {
        // Creating an HTTP client and executing the request
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            // Reading the response and converting it to a JsonNode
            String responseString = EntityUtils.toString(response.getEntity());
            return objectMapper.readTree(responseString);
        }
    }

    // Method to build the base URI based on the sandbox flag
    private URI buildBaseUri() throws URISyntaxException {
        // Selecting the appropriate base URL based on the useSandbox flag
        String baseUrl = useSandbox ? SANDBOX_URL : BASE_URL;
        // Building the URI with the access token as a parameter
        return new URIBuilder(baseUrl).setParameter("access_token", accessToken).build();
    }

    // Method to list all depositions
    public JsonNode listDepositions() throws IOException, URISyntaxException {
        // Building the URI for listing depositions
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions")
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP GET request and sending it
        HttpGet request = new HttpGet(uri);
        return sendRequest(request);
    }

    // Method to create a new deposition
    public JsonNode createDeposition() throws IOException, URISyntaxException {
        // Building the URI for creating a new deposition
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions")
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP POST request and sending it
        HttpPost request = new HttpPost(uri);
        return sendRequest(request);
    }

    // Method to retrieve a deposition by ID
    public JsonNode getDepositionById(int depositionId) throws IOException, URISyntaxException {
        // Building the URI for retrieving a deposition by ID
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId)
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP GET request and sending it
        HttpGet request = new HttpGet(uri);
        return sendRequest(request);
    }

    // Method to upload a file to a deposition
    public JsonNode uploadFile(int depositionId, File file) throws IOException, URISyntaxException {
        // Building the URI for uploading a file to a deposition
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/files")
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP POST request and setting up the file upload
        HttpPost request = new HttpPost(uri);
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addPart("file", new FileBody(file, ContentType.DEFAULT_BINARY, file.getName()));
        request.setEntity(entityBuilder.build());

        // Sending the request and returning the response
        return sendRequest(request);
    }

    // Method to retrieve all files for a deposition
    public JsonNode listFiles(int depositionId) throws IOException, URISyntaxException {
        // Building the URI for listing files in a deposition
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/files")
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP GET request and sending it
        HttpGet request = new HttpGet(uri);
        return sendRequest(request);
    }

    // Method to retrieve a single file for a deposition
    public JsonNode getFileById(int depositionId, String fileId) throws IOException, URISyntaxException {
        // Building the URI for retrieving a single file by ID in a deposition
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/files/" + fileId)
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP GET request and sending it
        HttpGet request = new HttpGet(uri);
        return sendRequest(request);
    }

    // Method to update a deposition file (e.g., rename)
    public JsonNode updateFile(int depositionId, String fileId, String newFileName) throws IOException, URISyntaxException {
        // Building the URI for updating a deposition file
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/files/" + fileId)
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP PUT request and setting up the new file name
        HttpPut request = new HttpPut(uri);
        StringBody stringBody = new StringBody(newFileName, ContentType.TEXT_PLAIN);
        request.setEntity(stringBody);

        // Sending the request and returning the response
        return sendRequest(request);
    }

    // Method to delete a deposition file
    public void deleteFile(int depositionId, String fileId) throws IOException, URISyntaxException {
        // Building the URI for deleting a deposition file
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/files/" + fileId)
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP DELETE request and sending it
        HttpDelete request = new HttpDelete(uri);

        // Executing the request through an HTTP client
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            httpClient.execute(request);
        }
    }

    // Method to publish a deposition
    public JsonNode publishDeposition(int depositionId) throws IOException, URISyntaxException {
        // Building the URI for publishing a deposition
        URI uri = new URIBuilder(BASE_URL + "/deposit/depositions/" + depositionId + "/actions/publish")
                .setParameter("access_token", accessToken)
                .build();
        // Creating an HTTP POST request and sending it
        HttpPost request = new HttpPost(uri);
        return sendRequest(request);
    }

    // Add more methods for other API endpoints as needed

    // Main method for testing the ZenodoRequest class
    public static void main(String[] args) {
        // Example usage with sandbox enabled
        String accessToken = "YOUR_ACCESS_TOKEN";
        ZenodoRequest zenodoRequest = new ZenodoRequest(accessToken, true);

        try {
            // Listing depositions and printing the result
            JsonNode depositions = zenodoRequest.listDepositions();
            System.out.println(depositions);

            // Add more API calls as needed for testing
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
