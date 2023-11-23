import java.io.InputStream;
import java.util.Objects;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class File {
    private String id;
    private String key;
    private long size;
    private String checksum;
    private Links links;

    // Constructors

    public File() {
    }

    public File(String id, String key, long size, String checksum, Links links) {
        this.id = id;
        this.key = key;
        this.size = size;
        this.checksum = checksum;
        this.links = links;
    }

    // Getters and setters for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and setters for key
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Getters and setters for size
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    // Getters and setters for checksum
    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    // Getters and setters for links
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    // Links class
    public static class Links {
        private String self;

        // Constructors

        public Links() {
        }

        public Links(String self) {
            this.self = self;
        }

        // Getters and setters for self
        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        // toString, equals, hashCode methods for Links class
        @Override
        public String toString() {
            return "Links{" +
                    "self='" + self + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Links links = (Links) o;
            return Objects.equals(self, links.self);
        }

        @Override
        public int hashCode() {
            return Objects.hash(self);
        }
    }

    // toString, equals, hashCode methods for File class
    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", size=" + size +
                ", checksum='" + checksum + '\'' +
                ", links=" + links +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size &&
                Objects.equals(id, file.id) &&
                Objects.equals(key, file.key) &&
                Objects.equals(checksum, file.checksum) &&
                Objects.equals(links, file.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, size, checksum, links);
    }

    public void downloadContent(String destinationPath) throws IOException {
        Objects.requireNonNull(destinationPath, "Destination path cannot be null");

        // Ensure that the links object is not null
        if (links == null || links.getSelf() == null) {
            throw new IllegalStateException("File links are not available for downloading");
        }

        // Create a URL object from the self link
        URL url = new URL(links.getSelf());

        // Open an InputStream from the URL
        try (InputStream inputStream = url.openStream()) {
            // Create a Path for the destination file
            Path destinationFilePath = Path.of(destinationPath);

            // Copy the input stream to the destination file
            Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
