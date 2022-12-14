package com.sparta.yajasu.repository;

import com.sparta.yajasu.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByOrderByModifiedAtDesc();

    Optional<Post> findById(Long id);
}
