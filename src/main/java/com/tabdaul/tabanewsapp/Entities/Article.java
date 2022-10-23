package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @SequenceGenerator(
            name = "article_seq",
            sequenceName = "article_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String body;
    private LocalDateTime createdAt;

    // TODO: make 'Author' > field as a foreign key (the logged in username)
    // TODO: make 'NumberOfLikes' > List of Likes field representing how many likes this article received
    // TODO: make 'NumberOfLikes' > List of Dislikes field representing how many dislikes this article received
    // TODO: make 'enabled' > boolean field representing if either this article is enabled or disabled by admin


    public Article(Long id, String title, String body, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = LocalDateTime.now();
    }

    public Article() {
        this.createdAt = LocalDateTime.now();
    }
}
