package com.tabdaul.tabanewsapp.Entities;

public class Article {
    private Long id;
    private String title;
    private String body;

    // TODO: make 'Author' > field as a foreign key (the logged in username)
    // TODO: make 'CreatedAt' > LocalDateTime field representing the date and time of article creation
    // TODO: make 'NumberOfLikes' > List of Likes field representing how many likes this article received
    // TODO: make 'NumberOfLikes' > List of Dislikes field representing how many dislikes this article received
    // TODO: make 'enabled' > boolean field representing if either this article is enabled or disabled by admin

    public Article() {

    }

    public Article(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
