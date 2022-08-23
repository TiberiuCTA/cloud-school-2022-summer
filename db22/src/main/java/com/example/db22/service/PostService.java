package com.example.db22.service;

import com.example.db22.factory.ReactFactory;
import com.example.db22.model.Comment;
import com.example.db22.model.Post;
import com.example.db22.model.React;
import com.example.db22.repository.PostRepository;
import com.example.db22.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public List<Post> getLast10Posts(){
        return postRepository.findAll().stream().skip(postRepository.findAll().stream().count()).collect(Collectors.toList());
        //return postRepository.getTop10Posts();
    }

    public List<Post> getPostWithMoreThan10Reacts(){
        return postRepository.getTop10Posts().stream().filter((post -> post.getReacts().size()>10)).toList();
    }

    public void addReactionToPost(Integer postId, String reactionName){
        Post post=postRepository.findById(postId).get();
        post.addReact(new ReactFactory().createReact(reactionName));
        postRepository.save(post);
    }

    public void addCommentToPost(Integer postId, Integer userId, String c){
        Date currentDate=Date.valueOf(String.valueOf(LocalDateTime.now()));
        Comment comment=new Comment(null, currentDate, userRepository.findById(userId).get(), c);

        postRepository.findById(postId).get().addComment(comment);
    }

}
