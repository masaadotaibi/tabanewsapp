package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @NotNull(message = "Article title is required.")
    @Size(min = 1, max = 100, message = "Article title must be at least 1 character and up to 100 characters")
    @Column(nullable = false, length = 100)
    private String title;

    @NotNull(message = "Article body is required.")
    @Size(min = 1, max = 500, message = "Article body must be at least 1 character and up to 500 characters")
    @Column(nullable = false, length = 500)
    private String body;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // TODO: make 'Author' > field as a foreign key (the logged in username)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "article", orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    // TODO: make 'NumberOfLikes' > List of Likes field representing how many likes this article received
    // TODO: make 'NumberOfLikes' > List of Dislikes field representing how many dislikes this article received
    // TODO: make 'enabled' > boolean field representing if either this article is enabled or disabled by admin


    public Article(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = LocalDateTime.now();
    }

    public Article() {
        this.createdAt = LocalDateTime.now();
    }
}
