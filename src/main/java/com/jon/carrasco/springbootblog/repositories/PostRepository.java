package com.jon.carrasco.springbootblog.repositories;

import com.jon.carrasco.springbootblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
