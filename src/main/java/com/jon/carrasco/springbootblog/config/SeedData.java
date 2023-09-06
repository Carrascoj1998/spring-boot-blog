package com.jon.carrasco.springbootblog.config;

import com.jon.carrasco.springbootblog.models.Post;
import com.jon.carrasco.springbootblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final PostService postService;


    public void run(String... args) throws Exception{

        List<Post> posts = postService.getAll();


        if(posts.size()== 0){

            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("this is the body of post 1");

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("this is the body of post 2");

            postService.save(post1);
            postService.save(post2);

        }

    }



}
