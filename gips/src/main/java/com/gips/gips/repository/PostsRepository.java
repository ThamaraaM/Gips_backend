package com.gips.gips.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gips.gips.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{
	Optional<Posts> findById(Long id);
}
