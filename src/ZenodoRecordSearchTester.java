import com.fasterxml.jackson.databind.JsonNode;

public class ZenodoRecordSearchTester {

    public static void main(String[] args) {
        // Instantiate the ZenodoRecordSearch class
        ZenodoRecordSearch zenodoRecordSearch = new ZenodoRecordSearch();

        // Test case 1: Valid record name with results
        testSearch(zenodoRecordSearch, "cats");

        // Test case 2: Valid record name with no results
        testSearch(zenodoRecordSearch, "nonexistent_record");

        // Test case 3: Invalid API URL (modify the URL to test an invalid case)
        testSearch(zenodoRecordSearch, "invalid_url");
    }

    private static void testSearch(ZenodoRecordSearch zenodoRecordSearch, String recordName) {
        System.out.println("Testing search for record: " + recordName);
        JsonNode result = zenodoRecordSearch.getFirstRecord(recordName);

        if (result != null) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("No result or error for the given record name: " + recordName);
        }

        System.out.println("--------");
    }
}
