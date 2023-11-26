import java.util.List;
import java.util.Objects;

public class Metadata {
    private String title;
    private String doi;
    private String publicationDate;
    private String description;
    private String accessRight;
    private List<Creator> creators;
    private List<String> keywords;
    private ResourceType resourceType;
    private Journal journal;
    private License license;
    private Relations relations;

    // Constructors

    public Metadata() {
    }

    public Metadata(String title, String doi, String publicationDate, String description, String accessRight,
                    List<Creator> creators, List<String> keywords, ResourceType resourceType, Journal journal,
                    License license, Relations relations) {
        this.title = title;
        this.doi = doi;
        this.publicationDate = publicationDate;
        this.description = description;
        this.accessRight = accessRight;
        this.creators = creators;
        this.keywords = keywords;
        this.resourceType = resourceType;
        this.journal = journal;
        this.license = license;
        this.relations = relations;
    }

    // Getters and setters for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and setters for doi
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    // Getters and setters for publicationDate
    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    // Getters and setters for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters and setters for accessRight
    public String getAccessRight() {
        return accessRight;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    // Getters and setters for creators
    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    // Getters and setters for keywords
    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    // Getters and setters for resourceType
    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    // Getters and setters for journal
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    // Getters and setters for license
    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    // Getters and setters for relations
    public Relations getRelations() {
        return relations;
    }

    public void setRelations(Relations relations) {
        this.relations = relations;
    }

    // toString, equals, hashCode methods for Metadata class
    @Override
    public String toString() {
        return "Metadata{" +
                "title='" + title + '\'' +
                ", doi='" + doi + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", description='" + description + '\'' +
                ", accessRight='" + accessRight + '\'' +
                ", creators=" + creators +
                ", keywords=" + keywords +
                ", resourceType=" + resourceType +
                ", journal=" + journal +
                ", license=" + license +
                ", relations=" + relations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(title, metadata.title) &&
                Objects.equals(doi, metadata.doi) &&
                Objects.equals(publicationDate, metadata.publicationDate) &&
                Objects.equals(description, metadata.description) &&
                Objects.equals(accessRight, metadata.accessRight) &&
                Objects.equals(creators, metadata.creators) &&
                Objects.equals(keywords, metadata.keywords) &&
                Objects.equals(resourceType, metadata.resourceType) &&
                Objects.equals(journal, metadata.journal) &&
                Objects.equals(license, metadata.license) &&
                Objects.equals(relations, metadata.relations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, doi, publicationDate, description, accessRight, creators, keywords, resourceType, journal, license, relations);
    }

    // Nested classes

    public static class Creator {
        private String name;
        private String affiliation;

        // Constructors

        // Getters and setters for name
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Getters and setters for affiliation
        public String getAffiliation() {
            return affiliation;
        }

        public void setAffiliation(String affiliation) {
            this.affiliation = affiliation;
        }

        // toString, equals, hashCode methods for Creator class
        @Override
        public String toString() {
            return "Creator{" +
                    "name='" + name + '\'' +
                    ", affiliation='" + affiliation + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Creator creator = (Creator) o;
            return Objects.equals(name, creator.name) &&
                    Objects.equals(affiliation, creator.affiliation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, affiliation);
        }
    }

    public static class ResourceType {
        private String title;
        private String type;

        // Constructors

        // Getters and setters for title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getters and setters for type
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        // toString, equals, hashCode methods for ResourceType class
        @Override
        public String toString() {
            return "ResourceType{" +
                    "title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResourceType that = (ResourceType) o;
            return Objects.equals(title, that.title) &&
                    Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, type);
        }
    }

    public static class Journal {
        private String issue;
        private String pages;
        private String title;
        private String volume;

        // Constructors

        // Getters and setters for issue
        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        // Getters and setters for pages
        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        // Getters and setters for title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getters and setters for volume
        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        // toString, equals, hashCode methods for Journal class
        @Override
        public String toString() {
            return "Journal{" +
                    "issue='" + issue + '\'' +
                    ", pages='" + pages + '\'' +
                    ", title='" + title + '\'' +
                    ", volume='" + volume + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Journal journal = (Journal) o;
            return Objects.equals(issue, journal.issue) &&
                    Objects.equals(pages, journal.pages) &&
                    Objects.equals(title, journal.title) &&
                    Objects.equals(volume, journal.volume);
        }

        @Override
        public int hashCode() {
            return Objects.hash(issue, pages, title, volume);
        }
    }

    public static class License {
        private String id;

        // Constructors

        // Getters and setters for id
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        // toString, equals, hashCode methods for License class
        @Override
        public String toString() {
            return "License{" +
                    "id='" + id + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() == o.getClass()) return false;
            License license = (License) o;
            return Objects.equals(id, license.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Relations {
        private List<Version> version;

        // Constructors

        // Getters and setters for version
        public List<Version> getVersion() {
            return version;
        }

        public void setVersion(List<Version> version) {
            this.version = version;
        }

        // toString, equals, hashCode methods for Relations class
        @Override
        public String toString() {
            return "Relations{" +
                    "version=" + version +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() == o.getClass()) return false;
            Relations relations = (Relations) o;
            return Objects.equals(version, relations.version);
        }

        @Override
        public int hashCode() {
            return Objects.hash(version);
        }

        // Nested class

        public static class Version {
            private int index;
            private boolean isLast;
            private Parent parent;

            // Constructors

            // Getters and setters for index
            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            // Getters and setters for isLast
            public boolean isLast() {
                return isLast;
            }

            public void setLast(boolean last) {
                isLast = last;
            }

            // Getters and setters for parent
            public Parent getParent() {
                return parent;
            }

            public void setParent(Parent parent) {
                this.parent = parent;
            }

            // toString, equals, hashCode methods for Version class
            @Override
            public String toString() {
                return "Version{" +
                        "index=" + index +
                        ", isLast=" + isLast +
                        ", parent=" + parent +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() == o.getClass()) return false;
                Version version = (Version) o;
                return index == version.index &&
                        isLast == version.isLast &&
                        Objects.equals(parent, version.parent);
            }

            @Override
            public int hashCode() {
                return Objects.hash(index, isLast, parent);
            }

            // Nested class

            public static class Parent {
                private String pidType;
                private String pidValue;

                // Constructors

                // Getters and setters for pidType
                public String getPidType() {
                    return pidType;
                }

                public void setPidType(String pidType) {
                    this.pidType = pidType;
                }

                // Getters and setters for pidValue
                public String getPidValue() {
                    return pidValue;
                }

                public void setPidValue(String pidValue) {
                    this.pidValue = pidValue;
                }

                // toString, equals, hashCode methods for Parent class
                @Override
                public String toString() {
                    return "Parent{" +
                            "pidType='" + pidType + '\'' +
                            ", pidValue='" + pidValue + '\'' +
                            '}';
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() == o.getClass()) return false;
                    Parent parent = (Parent) o;
                    return Objects.equals(pidType, parent.pidType) &&
                            Objects.equals(pidValue, parent.pidValue);
                }

                @Override
                public int hashCode() {
                    return Objects.hash(pidType, pidValue);
                }
            }
        }
    }
}
