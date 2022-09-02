package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="gender")
public class Gender {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_gender")
    private int id;

    @Column(name="key")
    private String key;

    @Column(name="title")
    private String title;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="gender",
            cascade= CascadeType.ALL)
    private List<Cat> cats;

    public Gender() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Gender gender = (Gender) o;
        return id == gender.id && key.equals(gender.key) && title.equals(gender.title) && Objects.equals(cats, gender.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, title, cats);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
