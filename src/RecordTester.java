import java.util.HashMap;
import java.util.Map;

public class RecordTester {
    public static void main(String[] args) {
        // Create some sample data
        String id = "123456";
        String title = "Sample Record";
        String description = "This is a sample record for testing purposes.";

        Map<String, Object> moreInfo = new HashMap<>();
        moreInfo.put("key1", "value1");
        moreInfo.put("key2", 42);
        moreInfo.put("key3", true);

        // Create a Record object
        Record record = new Record(id, title, description, moreInfo, null);

        // Print the Record object
        System.out.println("Record created:");
        System.out.println(record);
    }
}
