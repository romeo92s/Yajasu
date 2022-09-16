package com.sparta.yajasu.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private String username;
    private String content;
    private String password;

    public CommentRequestDto(String username, String content, String password) {
        this.username = username;
        this.content = content;
        this.password = password;
    }
    public CommentRequestDto(){

    }
}
