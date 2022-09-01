package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="document")
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_document")
    private int id;

    @Column(name="path")
    private String path;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_cat")
    private Cat cat;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_document_type")
    private DocumentType documentType;

    public Document() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Document document = (Document) o;
        return id == document.id && path.equals(document.path) && Objects.equals(description, document.description) && cat.equals(document.cat) && documentType.equals(document.documentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, description, cat, documentType);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", cat=" + cat +
                ", documentType=" + documentType +
                '}';
    }
}
