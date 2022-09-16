package com.sparta.yajasu.repository;

import com.sparta.yajasu.entity.Comment;
import com.sparta.yajasu.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByOrderByModifiedAtDesc();

    Optional<Comment> findById(Long id);
}
