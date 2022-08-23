package com.example.db22.model;

import com.example.db22.observer.PostObserver;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Observable;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    User user;

    @OneToMany
    List<Comment> comments;

    String content;

    @OneToMany
    List<React> reacts;

    @Transient
    PostObserver postObserver;

    public void addObserver() {
        postObserver = new PostObserver(this);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        postObserver.notify(comment);
    }

    public void addReact(React react) {
        reacts.add(react);
    }
}
