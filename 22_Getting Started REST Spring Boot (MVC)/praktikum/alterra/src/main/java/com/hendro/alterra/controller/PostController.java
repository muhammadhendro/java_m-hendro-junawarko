package com.hendro.alterra.controller;

import com.hendro.alterra.entity.Post;
import com.hendro.alterra.repository.PostRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getDetailPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @PostMapping("/posts")
    public Post createNewPost(@RequestBody Post payload) {
        return postRepository.save(payload);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        Optional<Post> postById = postRepository.findById(id);
        postById.ifPresent(res -> {
            postRepository.delete(res);
        });
    }

    @PutMapping("/posts/{id}")
    public Optional<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        Optional<Post> postById = postRepository.findById(id);
        postById.ifPresent(res -> {
            res.setName(post.getName());
            res.setDescription(post.getDescription());

            postRepository.save(res);
        });
        return postById;

    }


}
