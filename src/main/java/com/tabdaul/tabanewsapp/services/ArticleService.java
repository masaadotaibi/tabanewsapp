package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {

    private List<Article> articlesList = new ArrayList<Article>(Arrays.asList(
        new Article(1L, "First article", "This article will..."),
        new Article(2L, "Second article", "This article puts the light..."),
        new Article(3L, "Third article", "In This article we will..."),
        new Article(4L, "Fourth article", "Before beginning..."),
        new Article(5L, "Fifth article", "Continuing from our previous article, we...")
    ));

    public List<Article> findAll() {
        return articlesList;
    }

    public Article getArticleById(Long id) {
        Article articleOfId = articlesList.stream().filter(article -> article.getId().equals(id)).findFirst().get();

        return articleOfId;
    }

    public Article deleteArticleOfId(Long id) {
        Article articleDeleted = articlesList.remove(articlesList.indexOf(getArticleById(id)));

        return articleDeleted;
    }

    public boolean addNewArticle(Article newArticle) {
        return articlesList.add(newArticle);
    }
}
