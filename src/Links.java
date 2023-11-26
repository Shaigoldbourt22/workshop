import java.util.Objects;

public class Links {
    private String self;
    private String selfHtml;
    private String selfDoi;
    private String doi;
    private String parent;
    private String parentHtml;
    private String parentDoi;
    private String selfIiifManifest;
    private String selfIiifSequence;
    private String files;
    private String mediaFiles;
    private String archive;
    private String archiveMedia;
    private String latest;
    private String latestHtml;
    private String draft;
    private String versions;
    private String accessLinks;
    private String accessUsers;
    private String accessRequest;
    private String access;
    private String reserveDoi;
    private String communities;
    private String communitiesSuggestions;
    private String requests;

    // Constructors

    public Links() {
    }

    public Links(String self, String selfHtml, String selfDoi, String doi, String parent, String parentHtml,
                 String parentDoi, String selfIiifManifest, String selfIiifSequence, String files, String mediaFiles,
                 String archive, String archiveMedia, String latest, String latestHtml, String draft, String versions,
                 String accessLinks, String accessUsers, String accessRequest, String access, String reserveDoi,
                 String communities, String communitiesSuggestions, String requests) {
        this.self = self;
        this.selfHtml = selfHtml;
        this.selfDoi = selfDoi;
        this.doi = doi;
        this.parent = parent;
        this.parentHtml = parentHtml;
        this.parentDoi = parentDoi;
        this.selfIiifManifest = selfIiifManifest;
        this.selfIiifSequence = selfIiifSequence;
        this.files = files;
        this.mediaFiles = mediaFiles;
        this.archive = archive;
        this.archiveMedia = archiveMedia;
        this.latest = latest;
        this.latestHtml = latestHtml;
        this.draft = draft;
        this.versions = versions;
        this.accessLinks = accessLinks;
        this.accessUsers = accessUsers;
        this.accessRequest = accessRequest;
        this.access = access;
        this.reserveDoi = reserveDoi;
        this.communities = communities;
        this.communitiesSuggestions = communitiesSuggestions;
        this.requests = requests;
    }

    // Getters and setters for self, selfHtml, selfDoi
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getSelfHtml() {
        return selfHtml;
    }

    public void setSelfHtml(String selfHtml) {
        this.selfHtml = selfHtml;
    }

    public String getSelfDoi() {
        return selfDoi;
    }

    public void setSelfDoi(String selfDoi) {
        this.selfDoi = selfDoi;
    }


    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", selfHtml='" + selfHtml + '\'' +
                ", selfDoi='" + selfDoi + '\'' +
                ", doi='" + doi + '\'' +
                ", parent='" + parent + '\'' +
                ", parentHtml='" + parentHtml + '\'' +
                ", parentDoi='" + parentDoi + '\'' +
                ", selfIiifManifest='" + selfIiifManifest + '\'' +
                ", selfIiifSequence='" + selfIiifSequence + '\'' +
                ", files='" + files + '\'' +
                ", mediaFiles='" + mediaFiles + '\'' +
                ", archive='" + archive + '\'' +
                ", archiveMedia='" + archiveMedia + '\'' +
                ", latest='" + latest + '\'' +
                ", latestHtml='" + latestHtml + '\'' +
                ", draft='" + draft + '\'' +
                ", versions='" + versions + '\'' +
                ", accessLinks='" + accessLinks + '\'' +
                ", accessUsers='" + accessUsers + '\'' +
                ", accessRequest='" + accessRequest + '\'' +
                ", access='" + access + '\'' +
                ", reserveDoi='" + reserveDoi + '\'' +
                ", communities='" + communities + '\'' +
                ", communitiesSuggestions='" + communitiesSuggestions + '\'' +
                ", requests='" + requests + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(self, links.self) &&
                Objects.equals(selfHtml, links.selfHtml) &&
                Objects.equals(selfDoi, links.selfDoi) &&
                Objects.equals(doi, links.doi) &&
                Objects.equals(parent, links.parent) &&
                Objects.equals(parentHtml, links.parentHtml) &&
                Objects.equals(parentDoi, links.parentDoi) &&
                Objects.equals(selfIiifManifest, links.selfIiifManifest) &&
                Objects.equals(selfIiifSequence, links.selfIiifSequence) &&
                Objects.equals(files, links.files) &&
                Objects.equals(mediaFiles, links.mediaFiles) &&
                Objects.equals(archive, links.archive) &&
                Objects.equals(archiveMedia, links.archiveMedia) &&
                Objects.equals(latest, links.latest) &&
                Objects.equals(latestHtml, links.latestHtml) &&
                Objects.equals(draft, links.draft) &&
                Objects.equals(versions, links.versions) &&
                Objects.equals(accessLinks, links.accessLinks) &&
                Objects.equals(accessUsers, links.accessUsers) &&
                Objects.equals(accessRequest, links.accessRequest) &&
                Objects.equals(access, links.access) &&
                Objects.equals(reserveDoi, links.reserveDoi) &&
                Objects.equals(communities, links.communities) &&
                Objects.equals(communitiesSuggestions, links.communitiesSuggestions) &&
                Objects.equals(requests, links.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self, selfHtml, selfDoi, doi, parent, parentHtml, parentDoi, selfIiifManifest, selfIiifSequence,
                files, mediaFiles, archive, archiveMedia, latest, latestHtml, draft, versions, accessLinks, accessUsers,
                accessRequest, access, reserveDoi, communities, communitiesSuggestions, requests);
    }
}
