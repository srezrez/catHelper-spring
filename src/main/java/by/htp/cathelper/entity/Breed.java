package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="breed")
public class Breed {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_breed")
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="breed",
            cascade= CascadeType.ALL)
    private List<Cat> cats;

    public Breed() {
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

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Breed breed = (Breed) o;
        return id == breed.id && title.equals(breed.title) && Objects.equals(cats, breed.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cats);
    }
}
