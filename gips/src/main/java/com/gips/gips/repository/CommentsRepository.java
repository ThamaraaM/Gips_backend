package com.gips.gips.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gips.gips.domain.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long>{
	Optional<Comments> findById(Long id);
}
