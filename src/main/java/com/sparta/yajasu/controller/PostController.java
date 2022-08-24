package com.sparta.yajasu.controller;

import com.sparta.yajasu.dto.PostRequestDto;
import com.sparta.yajasu.dto.PostResponseDto;
import com.sparta.yajasu.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public PostResponseDto<?> createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }
    //전체조회
    @GetMapping("/api/posts")
    public PostResponseDto<?> getAllPost(){
        return postService.getAllPost();
    }
    //한개조회
    @GetMapping("/api/posts/{id}")
    public PostResponseDto<?> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }
    @PutMapping("/api/posts/{id}")
    public PostResponseDto<?> updatePost(@RequestBody PostRequestDto requestDto,@PathVariable Long id){
        return postService.updatePost(requestDto,id);
    }

}
