package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cat")
public class Cat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cat")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="birthDate")
    private Date birthDate;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_user_owner")
    private User owner;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_breed")
    private Breed breed;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_gender")
    private Gender gender;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cat",
            cascade= CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cat",
            cascade= CascadeType.ALL)
    private List<Request> requests;

    public Cat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && name.equals(cat.name) && birthDate.equals(cat.birthDate) && owner.equals(cat.owner) && breed.equals(cat.breed) && gender.equals(cat.gender) && Objects.equals(documents, cat.documents) && Objects.equals(requests, cat.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, owner, breed, gender, documents, requests);
    }
}
