package com.alterra.graphql.controller;

import com.alterra.graphql.domain.dao.AuthorDao;
import com.alterra.graphql.domain.dao.PostDao;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @QueryMapping
    List<PostDao> posts() {
        List<PostDao> posts = new ArrayList<>();
        posts.add(new PostDao(1L, "Java","Spring","Boot"));
        return posts;

    }

//    List<PostDao> recentPosts() {
//        List<PostDao> posts = new ArrayList<>();
//        posts.add(new PostDao(1L, "a","b","c"));
//        return posts;
//
//    }


}
