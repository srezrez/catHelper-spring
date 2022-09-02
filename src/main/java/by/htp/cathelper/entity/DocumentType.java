package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_document_type")
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="documentType",
            cascade= CascadeType.ALL)
    private List<Document> documents;

    public DocumentType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return id == that.id && title.equals(that.title) && Objects.equals(documents, that.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, documents);
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
