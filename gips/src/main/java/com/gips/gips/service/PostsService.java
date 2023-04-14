package com.gips.gips.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gips.gips.domain.Posts;
import com.gips.gips.exception.BadRequestException;
import com.gips.gips.repository.PostsRepository;

@Service
public class PostsService {
	@Autowired
	private PostsRepository postRepository;
	
	public List<Posts> listAll() {
        return postRepository.findAll();
    }
	
	public Posts findByIdOrThrowBadRequestException(long id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Aluno not Found"));
	}
}
