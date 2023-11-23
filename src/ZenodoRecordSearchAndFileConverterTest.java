import com.fasterxml.jackson.databind.JsonNode;

public class ZenodoRecordSearchAndFileConverterTest {

    public static void main(String[] args) {
        testSearchAndConvert();
    }

    private static void testSearchAndConvert() {
        ZenodoRecordSearch recordSearch = new ZenodoRecordSearch();
        String recordName = "cats";

        // Search for the record
        JsonNode firstRecord = recordSearch.getFirstRecord(recordName);

        // If a record is found, access the "files" field and convert it to a File object
        if (firstRecord != null) {
            JsonNode filesNode = firstRecord.path("files");

            if (filesNode.size() > 0) {
                JsonNode firstFile = filesNode.get(0);

                // Convert the first file to a File object
                File file = FileConverter.convertJsonNodeToFile(firstFile);

                // Display information about the file
                System.out.println("Converted File:");
                System.out.println("ID: " + file.getId());
                System.out.println("Key: " + file.getKey());
                System.out.println("Size: " + file.getSize());
                System.out.println("Checksum: " + file.getChecksum());
                System.out.println("Self Link: " + file.getLinks().getSelf());
            } else {
                System.out.println("No files found for the given record: " + recordName);
            }
        } else {
            System.out.println("No record found for the given name: " + recordName);
        }
    }
}
