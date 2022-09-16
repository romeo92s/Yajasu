package com.sparta.yajasu.entity;


import com.sparta.yajasu.dto.comment.CommentRequestDto;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    String content;
    @Column(nullable = false)
    String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Post_id")
    private Post Post;

    public Comment(String username, String content, String password) {
        this.username = username;
        this.content = content;
        this.password = password;
    }

    public Comment() {

    }
    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}
