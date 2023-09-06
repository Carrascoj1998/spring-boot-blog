package com.jon.carrasco.springbootblog.controller;

import com.jon.carrasco.springbootblog.models.Post;
import com.jon.carrasco.springbootblog.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {


    private final PostService postService;

    @GetMapping("/")
    public String home(Model model){

        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }

}
