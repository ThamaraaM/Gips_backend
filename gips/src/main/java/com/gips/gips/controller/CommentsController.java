package com.gips.gips.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gips.gips.domain.Comments;
import com.gips.gips.requests.CommentsPostRequestBody;
import com.gips.gips.service.CommentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
public class CommentsController {
private final CommentsService commentsService;
	
	@GetMapping
    public ResponseEntity<List<Comments>> list(){
        return ResponseEntity.ok(commentsService.listAll());
    }

	@GetMapping(path = "/{id}")
    public ResponseEntity<Comments> findById(@PathVariable long id){
        return ResponseEntity.ok(commentsService.findByIdOrThrowBadRequestException(id));
    }
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		commentsService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Comments> save(@RequestBody CommentsPostRequestBody commentsPostRequestBody){
		return new ResponseEntity<>(commentsService.save(commentsPostRequestBody), HttpStatus.CREATED);
	}
}
