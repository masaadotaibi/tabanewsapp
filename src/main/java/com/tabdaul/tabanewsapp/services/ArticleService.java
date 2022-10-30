package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.Article;

import java.util.List;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/30/2022 at 03:00
 */
public interface ArticleService {

    List<Article> findAll();
    Article getArticleById(Long id);
    String deleteArticleOfId(Long id);
    Article addNewArticle(Article newArticle);

}
