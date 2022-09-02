package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="activity")
public class Activity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_activity")
    private int id;

    @Column(name="key")
    private String key;

    @Column(name="title")
    private String title;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="activity",
        cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    private List<User> users;

    public Activity() {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id && key.equals(activity.key) && title.equals(activity.title) && Objects.equals(users, activity.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, title, users);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
