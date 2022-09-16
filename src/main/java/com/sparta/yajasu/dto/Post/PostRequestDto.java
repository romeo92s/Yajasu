package com.sparta.yajasu.dto.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    public PostRequestDto(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
    public PostRequestDto(){

    }
}
