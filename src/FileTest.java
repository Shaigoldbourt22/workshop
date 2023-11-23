import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        // Creating a File object
        File file = new File();

        // Setting values using setters
        file.setId("25e2fdc7-0ec0-475a-818c-ded5e465a81a");
        file.setKey("615-621.pdf");
        file.setSize(176877);
        file.setChecksum("md5:0d362a62543c366aa91d802382c44c55");

        // Creating a Links object
        File.Links links = new File.Links();
        links.setSelf("https://zenodo.org/api/records/10183676/files/615-621.pdf/content");

        // Setting the Links object using the setter in the File class
        file.setLinks(links);

        // Asserting the File object using toString()
        assert "File{id='25e2fdc7-0ec0-475a-818c-ded5e465a81a', key='615-621.pdf', size=176877, checksum='md5:0d362a62543c366aa91d802382c44c55', links=Links{self='https://zenodo.org/api/records/10183676/files/615-621.pdf/content'}}".equals(file.toString());

        // Accessing values using getters and asserting
        assert "25e2fdc7-0ec0-475a-818c-ded5e465a81a".equals(file.getId());
        assert "615-621.pdf".equals(file.getKey());
        assert 176877 == file.getSize();
        assert "md5:0d362a62543c366aa91d802382c44c55".equals(file.getChecksum());

        // Accessing Links object and its values and asserting
        File.Links fileLinks = file.getLinks();
        assert "https://zenodo.org/api/records/10183676/files/615-621.pdf/content".equals(fileLinks.getSelf());

        // Download content to the specified path and assert
        try {
            String destinationPath = "C:\\Users\\admin\\Desktop\\monthly_report.pdf";
            file.downloadContent(destinationPath);
            assert true; // Asserting that the download was successful
        } catch (IOException e) {
            assert false : "Error downloading content: " + e.getMessage(); // Asserting that the download failed
        }

        System.out.println("File class is good!");
    }
}
