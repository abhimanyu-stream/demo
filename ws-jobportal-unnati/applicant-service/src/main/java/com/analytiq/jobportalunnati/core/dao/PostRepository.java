package com.analytiq.jobportalunnati.core.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.analytiq.jobportalunnati.core.model.Post;



public interface PostRepository extends JpaRepository<Post, Long> {
	
	Page<Post> findByCreatedByAndDeletedIsFalse(Long userId, Pageable pageable);
    Optional<Post> findByIdAndDeletedIsFalse(Long postId);

}
