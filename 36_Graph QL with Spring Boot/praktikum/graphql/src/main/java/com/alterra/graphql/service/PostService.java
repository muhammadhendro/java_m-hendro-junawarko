//package com.alterra.graphql.service;
//
//import com.alterra.graphql.domain.dao.PostDao;
//import com.alterra.graphql.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PostService {
//
//
//    private final PostRepository postRepository;
//
//    public PostService(final PostRepository postRepository) {
//        this.postRepository = postRepository ;
//    }
//
//
//    public PostDao addPost(  Long id,  String title,  String text,String category) {
//        PostDao postDao = new PostDao();
//        postDao.setId(id);
//        postDao.setTitle(title);
//        postDao.setText(text);
//        postDao.setCategory(category);
//
//        return this.postRepository.save(postDao);
//    }
//
//
//    public List<PostDao> getAllPost( int count) {
//        return this.postRepository.findAll().stream().limit(count).collect(Collectors.toList());
//    }
//
//
//    public Optional<PostDao> getPost( Long id) {
//        return this.postRepository.findById(id);
//    }
//}
