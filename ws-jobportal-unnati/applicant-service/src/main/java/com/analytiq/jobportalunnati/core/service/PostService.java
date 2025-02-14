package com.analytiq.jobportalunnati.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.analytiq.jobportalunnati.core.dto.PostRequest;


public interface PostService {
	
	PostRequest create(PostRequest postDto);
    Page<PostRequest> getPostsByUserId(Long userId, Pageable pageable);
    PostRequest getPostById(Long postId);
    PostRequest update(PostRequest postDto);
    PostRequest delete(Long postId);

}
