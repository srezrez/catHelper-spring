package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_status")
    private int id;

    @Column(name="key")
    private String key;

    @Column(name="title")
    private String title;

    @Column(name="note")
    private String note;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="request",
            cascade= CascadeType.ALL)
    private List<Request> requests;

    public Status() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Status status = (Status) o;
        return id == status.id && key.equals(status.key) && title.equals(status.title) && Objects.equals(note, status.note) && Objects.equals(requests, status.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, title, note, requests);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
