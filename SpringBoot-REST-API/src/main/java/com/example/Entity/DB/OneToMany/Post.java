package com.example.Entity.DB.OneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String title;
    private String description;
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_id", referencedColumnName = "id")
    private List<Comment> comments = new ArrayList<Comment>();

    public Post() {

    }

    public Post(long id, String title, String description, String author, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
