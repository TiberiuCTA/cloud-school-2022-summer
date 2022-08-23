package com.example.db22.controller;

import com.example.db22.factory.ReactFactory;
import com.example.db22.model.Comment;
import com.example.db22.model.Post;
import com.example.db22.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    @PostMapping()
    public Post insert(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping("last-ten")
    public List<Post> getLast10(){
        return postService.getLast10Posts();
    }

    @GetMapping("10-reacts")
    public List<Post> getPostWithMoreThan10Reacts(){
        return postService.getPostWithMoreThan10Reacts();
    }

    @PutMapping("add-react/{postId}/{reactionName}")
    public void addReactionToPost(@PathVariable Integer postId, @PathVariable String reactionName){
        postService.addReactionToPost(postId, reactionName);
    }

    @PutMapping("add-react/{postId}/{userId}/{c}")
    public void addCommentToPost(@PathVariable Integer postId, @PathVariable Integer userId,@PathVariable String c){
        postService.addCommentToPost(postId, userId, c);
    }
}
