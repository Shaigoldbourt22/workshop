import com.fasterxml.jackson.databind.JsonNode;

public class ZenodoRecordSearchAndConverterTester {

    public static void main(String[] args) {
        // Specify the record name to search for
        String recordName = "cats";

        // Create an instance of ZenodoRecordSearch
        ZenodoRecordSearch recordSearch = new ZenodoRecordSearch();

        // Get the first record as a JsonNode
        JsonNode jsonNode = recordSearch.getFirstRecord(recordName);

        if (jsonNode != null) {
            // Convert the JsonNode to a Record using RecordConverter
            Record record = RecordConverter.convertJsonNodeToRecord(jsonNode);

            // Print the converted Record
            System.out.println("Converted Record:");
            System.out.println("ID: " + record.getId());
            System.out.println("Title: " + record.getTitle());
            System.out.println("Description: " + record.getDescription());
            System.out.println("More Info: " + record.getMoreInfo());
            System.out.println("files = " + record.getFiles());
            System.out.println(record.getMoreInfo().get("created"));
        } else {
            System.out.println("No record found for the given query: " + recordName);
        }
    }
}
