package com.jon.carrasco.springbootblog.repositories;

import com.jon.carrasco.springbootblog.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
