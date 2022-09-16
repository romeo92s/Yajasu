package com.sparta.yajasu.controller;

import com.sparta.yajasu.dto.comment.CommentRequestDto;
import com.sparta.yajasu.dto.comment.CommentResponseDto;
import com.sparta.yajasu.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //댓글생성
    @PostMapping("/api/posts/{id}/comments")
    public CommentResponseDto<?> createComment(@RequestBody CommentRequestDto requestDto,
                                               @PathVariable Long id){
        return commentService.createComment(requestDto,id);
    }
    //댓글 조회

//    @GetMapping("/api/posts/{id}/comments")
//    public CommentResponseDto<?> getComment(){
//        return commentService.getComment();
//    }

    //어느게시물의 댓글인지
    //댓글 수정
//    @PutMapping("/api/posts/{id}/comments")
//    public CommentResponseDto<?> updateComment(@RequestBody CommentRequestDto requestDto,
//                                               @PathVariable Long id){
//        return commentService.updateComment(requestDto, id);
//    }
    //댓글 삭제


}
