package com.gips.gips.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gips.gips.domain.Comments;
import com.gips.gips.exception.BadRequestException;
import com.gips.gips.repository.CommentsRepository;
import com.gips.gips.requests.CommentsPostRequestBody;



@Service
public class CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;
	
	public List<Comments> listAll() {
        return commentsRepository.findAll();
    }
	
	public Comments findByIdOrThrowBadRequestException(long id) {
		return commentsRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Comment not Found"));
	}
	
	public void delete(long id) {
		commentsRepository.delete(findByIdOrThrowBadRequestException(id));
	}
	
	@Transactional
	public Comments save(CommentsPostRequestBody commentsPostRequestBody) {
		return commentsRepository.save(Comments.builder()
						.comment(commentsPostRequestBody.getComment())
						.build()
				);
	}
}
