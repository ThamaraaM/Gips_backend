package com.gips.gips.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gips.gips.domain.Posts;
import com.gips.gips.service.PostsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostsController {
	
	private final PostsService postService;
	
	@GetMapping
    public ResponseEntity<List<Posts>> list(){
        return ResponseEntity.ok(postService.listAll());
    }

	@GetMapping(path = "/{id}")
    public ResponseEntity<Posts> findById(@PathVariable long id){
        return ResponseEntity.ok(postService.findByIdOrThrowBadRequestException(id));
    }
	
}
