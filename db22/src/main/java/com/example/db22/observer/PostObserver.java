package com.example.db22.observer;

import com.example.db22.model.Comment;
import com.example.db22.model.Post;

public class PostObserver {
    private Post observedPost;

    public PostObserver(Post post){
        observedPost=post;
    }
    public void notify(Comment comment) {
        System.out.println(observedPost.getUser().getName()+ " you have a new comment! -> "+comment.getContent());
    }
}
