package com.jon.carrasco.springbootblog.config;

import com.jon.carrasco.springbootblog.models.Account;
import com.jon.carrasco.springbootblog.models.Post;
import com.jon.carrasco.springbootblog.service.AccountService;
import com.jon.carrasco.springbootblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final PostService postService;

    private final AccountService accountService;


    public void run(String... args) throws Exception{

        List<Post> posts = postService.getAll();


        if(posts.size()== 0){


            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");

            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("this is the body of post 1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("this is the body of post 2");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);

        }

    }



}
