package com.jon.carrasco.springbootblog.config;

import com.jon.carrasco.springbootblog.models.Account;
import com.jon.carrasco.springbootblog.models.Authority;
import com.jon.carrasco.springbootblog.models.Post;
import com.jon.carrasco.springbootblog.repositories.AuthorityRepository;
import com.jon.carrasco.springbootblog.service.AccountService;
import com.jon.carrasco.springbootblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner {

    private final PostService postService;
    private final AccountService accountService;
    private final AuthorityRepository authorityRepository;

    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.isEmpty()) {
            // Create and save authorities
            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            // Create and save accounts with authorities
            Account account1 = new Account();
            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");
            Set<Authority> authorities1 = new HashSet<>();
            authorities1.add(user); // Add the user authority
            account1.setAuthorities(authorities1);
            accountService.save(account1);

            Account account2 = new Account();
            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");
            Set<Authority> authorities2 = new HashSet<>();
            authorities2.add(user); // Add the user authority
            authorities2.add(admin); // Add the admin authority
            account2.setAuthorities(authorities2);
            accountService.save(account2);

            // Create and save posts
            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("this is the body of post 1");
            post1.setAccount(account1);
            postService.save(post1);

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("this is the body of post 2");
            post2.setAccount(account2);
            postService.save(post2);
        }
    }




}
