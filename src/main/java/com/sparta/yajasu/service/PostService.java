package com.sparta.yajasu.service;

import com.sparta.yajasu.dto.PasswordDto;
import com.sparta.yajasu.dto.PostRequestDto;
import com.sparta.yajasu.dto.PostResponseDto;
import com.sparta.yajasu.entity.Post;
import com.sparta.yajasu.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto<?> createPost(PostRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        return PostResponseDto.success(post);
    }
    //  전체조회
    @Transactional
    public PostResponseDto<?> getAllPost(){
        return PostResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
    }
    //하나조회
    @Transactional
    public PostResponseDto<?> getPost(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()){
            return PostResponseDto.fail("NULL_POST_ID","게시글이 존재하지 않습니다.");
        }
        return PostResponseDto.success(optionalPost.get());
    }
    @Transactional
    public PostResponseDto<?> updatePost(PostRequestDto requestDto,Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()){
            return PostResponseDto.fail("NULL_POST_ID","게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        post.update(requestDto);
        return PostResponseDto.success(post);
    }
    @Transactional
    public PostResponseDto<?> deletePost(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()){
            return PostResponseDto.fail("NULL_POST_ID","게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        postRepository.delete(post);
        return PostResponseDto.success(true);
    }
    @Transactional
    public PostResponseDto<?> validateAuthorByPassword(Long id, PasswordDto password){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()){
            return PostResponseDto.fail("NULL_POST_ID","게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();

        if(!post.getPassword().equals(password.getPassword())){
            return PostResponseDto.fail("PASSWORD_NOT_CORRECT","게시글이 존재하지 않습니다.");
        }
        return PostResponseDto.success(true);
    }
}
