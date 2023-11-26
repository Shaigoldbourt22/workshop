import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

public class Record {
    private String created;
    private String modified;
    private long id;
    private String conceptRecId;
    private String doi;
    private String doiUrl;
    private String title;
    private Metadata metadata;
    private Links links;
    private String updated;
    private String recid;
    private int revision;
    private List<File> files;

    // Constructors
    public Record() {
    }

    public Record(String created, String modified, long id, String conceptrecid, String doi, String doiUrl,
                  String title, Metadata metadata, Links links, String updated, String recid, int revision,
                  List<File> files) {
        this.created = created;
        this.modified = modified;
        this.id = id;
        this.conceptRecId = conceptrecid;
        this.doi = doi;
        this.doiUrl = doiUrl;
        this.title = title;
        this.metadata = metadata;
        this.links = links;
        this.updated = updated;
        this.recid = recid;
        this.revision = revision;
        this.files = files;
    }

    

    // Getters and setters for created
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    // Getters and setters for modified
    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    // Getters and setters for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getters and setters for conceptRecId
    public String getConceptRecId() {
        return conceptRecId;
    }

    public void setConceptRecId(String conceptRecId) {
        this.conceptRecId = conceptRecId;
    }

    // Getters and setters for doi
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    // Getters and setters for doiUrl
    public String getDoiUrl() {
        return doiUrl;
    }

    public void setDoiUrl(String doiUrl) {
        this.doiUrl = doiUrl;
    }

    // Getters and setters for metadata
    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    // Getters and setters for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters for links
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    // Getters and setters for updated
    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    // Getters and setters for recid
    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid;
    }

    // Getters and setters for revision
    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    // Getters and setters for files
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    // toString, equals, hashCode methods for Record class
    @Override
    public String toString() {
        return "Record{" +
                "created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", id=" + id +
                ", conceptRecId='" + conceptRecId + '\'' +
                ", doi='" + doi + '\'' +
                ", doiUrl='" + doiUrl + '\'' +
                ", metadata=" + metadata +
                ", title='" + title + '\'' +
                ", links=" + links +
                ", updated='" + updated + '\'' +
                ", recid='" + recid + '\'' +
                ", revision=" + revision +
                ", files=" + files +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                revision == record.revision &&
                Objects.equals(created, record.created) &&
                Objects.equals(modified, record.modified) &&
                Objects.equals(conceptRecId, record.conceptRecId) &&
                Objects.equals(doi, record.doi) &&
                Objects.equals(doiUrl, record.doiUrl) &&
                Objects.equals(metadata, record.metadata) &&
                Objects.equals(title, record.title) &&
                Objects.equals(links, record.links) &&
                Objects.equals(updated, record.updated) &&
                Objects.equals(recid, record.recid) &&
                Objects.equals(files, record.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, modified, id, conceptRecId, doi, doiUrl, metadata, title, links, updated, recid, revision, files);
    }

    

    /// Function to download the content of a record
    public void downloadContent(String destinationPath) throws IOException {
        Objects.requireNonNull(destinationPath, "Destination path cannot be null");

        // Ensure that the links object is not null
        if (links == null || links.getSelf() == null) {
            throw new IllegalStateException("Record links are not available for downloading");
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
