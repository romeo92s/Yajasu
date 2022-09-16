package com.sparta.yajasu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.yajasu.dto.Post.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false)
    private String author;
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "Post",fetch =FetchType.LAZY,cascade = CascadeType.REMOVE)
    List<Comment> commentList;

    // mappedBy 옵션은 객체간 양방향 연관관계일 경우에 보통 사용한다, 즉 mappedBy ="Post"는 양방향 연관관계일때 반대쪽에 매핑되는
    //FetchType

    public Post(PostRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
    public void update(PostRequestDto requestDto){
        this.title= requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}
