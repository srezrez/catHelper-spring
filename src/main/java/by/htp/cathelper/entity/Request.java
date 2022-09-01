package by.htp.cathelper.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="request")
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_request")
    private int id;

    @Column(name="date_request")
    private Date dateRequest;

    @Column(name="date_issue")
    private Date dateIssue;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_user_requester")
    private User requester;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_cat")
    private Cat cat;

    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="id_status")
    private Status status;

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Request request = (Request) o;
        return id == request.id && dateRequest.equals(request.dateRequest) && dateIssue.equals(request.dateIssue) && requester.equals(request.requester) && cat.equals(request.cat) && status.equals(request.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateRequest, dateIssue, requester, cat, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", dateRequest=" + dateRequest +
                ", dateIssue=" + dateIssue +
                ", requester=" + requester +
                ", cat=" + cat +
                ", status=" + status +
                '}';
    }
}
