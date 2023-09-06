package com.jon.carrasco.springbootblog.controller;

import com.jon.carrasco.springbootblog.models.Post;
import com.jon.carrasco.springbootblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model){
        //find the post by id

        Optional<Post> optionalPost = postService.getById(id);

        //if the post exists, shove into the model
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }else {
            return "404";
        }
    }
}
