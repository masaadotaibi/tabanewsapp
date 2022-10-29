package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/28/2022 at 06:49
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_seq",
            sequenceName = "comment_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;


    @NotBlank
    @Column(nullable = false)
    private String content;

    // we used CascadeType.ALL to inform that whatever changes in the user table and related to the comment, it will
    // be automatically cascaded to the comment table, changes like changing username, deleting user - will delete
    // comments also, editing comment, etc.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commenter_id")
    private User commenter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;
}
