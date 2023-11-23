import java.util.List;
import java.util.Map;

public class Record {
    private String id;
    private String title;
    private String description;
    private Map<String, Object> moreInfo;

    private List<File> files;

    public Record(String id, String title, String description, Map<String, Object> moreInfo, List<File> files ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.moreInfo = moreInfo;
        this.files = files;
    }

    // Getter methods for fields

    public String getId() {
        return id;
    }

    public List<File> getFiles(){
        return files;
    }

    public void setFiles(List<File> newFiles){
        files = newFiles;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getMoreInfo() {
        return moreInfo;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", moreInfo=" + moreInfo +
                '}';
    }
}
