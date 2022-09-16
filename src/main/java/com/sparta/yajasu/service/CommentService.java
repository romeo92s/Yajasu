package com.sparta.yajasu.service;

import com.sparta.yajasu.dto.Post.PostResponseDto;
import com.sparta.yajasu.dto.comment.CommentRequestDto;
import com.sparta.yajasu.dto.comment.CommentResponseDto;
import com.sparta.yajasu.entity.Comment;
import com.sparta.yajasu.entity.Post;
import com.sparta.yajasu.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성
    @Transactional
    public CommentResponseDto<?> createComment(CommentRequestDto requestDto,Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            return CommentResponseDto.fail("NULL_COMMENT_ID", "댓글이 존재하지 않습니다.");
        }
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
        return CommentResponseDto.success(comment);
    }
    //댓글 조회
//    @Transactional
//    public CommentResponseDto<?> getComment(){
//        return CommentResponseDto.success(commentRepository.findAllByOrderByModifiedAtDesc());
//    }


    //댓글 수정
//    @Transactional
//    public CommentResponseDto<?> updateComment(CommentRequestDto requestDto,Long id) {
//        Optional<Comment> optionalComment = commentRepository.findById(id);
//        if (optionalComment.isEmpty()) {
//            return CommentResponseDto.fail("NULL_COMMENT_ID", "댓글이 존재하지 않습니다.");
//        }
//        Comment comment = optionalComment.get();
//        comment.update(requestDto);
//        return CommentResponseDto.success(comment);
//
//    }


}
