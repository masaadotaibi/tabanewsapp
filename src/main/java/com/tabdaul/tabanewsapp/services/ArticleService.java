package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.Article;
import com.tabdaul.tabanewsapp.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Get all articles
     * @return List of all articles => List<Article>
     */
    public List<Article> findAll() {
        // TODO: find out how to use pagination as below line will just show 10 items only, rather than paging
        return articleRepository.findAll(Pageable.ofSize(10)).get().toList();
//        return articleRepository.findAll();
    }

    /**
     * Get the Article of passed id parameter
     * @param id represents the ID of the article we wish to fetch from DB
     * @return The Article of passed ID
     */
    public Article getArticleById(Long id) {
        Article articleOfId = articleRepository.findById(id).get();

        // TODO: handle the exception of the article of passed id not being found

        return articleOfId;
    }

    /**
     * Delete the Article of passed id parameter
     * @param id represents the ID of the article we wish to delete
     * @return Confirmation message of article deletion
     */
    public String deleteArticleOfId(Long id) {
        articleRepository.deleteById(id);

        // TODO: handle the exception of the article of passed id not present in db

        return "Article of id=" + id + " is deleted";
    }

    /**
     * Adds the passed article to the DB
     * @param newArticle represents the newly created article
     * @return The newly created article to the caller of the method
     */
    public Article addNewArticle(Article newArticle) {
        Article newAddedArticle = articleRepository.save(newArticle);

        return newAddedArticle;
    }
}
