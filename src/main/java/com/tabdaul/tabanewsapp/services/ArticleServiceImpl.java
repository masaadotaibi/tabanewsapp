package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.Article;
import com.tabdaul.tabanewsapp.error.MissingFieldException;
import com.tabdaul.tabanewsapp.error.NotFoundException;
import com.tabdaul.tabanewsapp.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Get all articles
     * @return List of all articles => List<Article>
     */
    @Override
    public List<Article> findAll() {
        // TODO: find out how to use pagination as below commented line will just show 10 items only, rather than paging
//        return articleRepository.findAll(Pageable.ofSize(10)).get().toList();
        return articleRepository.findAll();
    }

    /**
     * Get the Article of passed id parameter
     * @param id represents the ID of the article we wish to fetch from DB
     * @return The Article of passed ID
     */
    @Override
    public Article getArticleById(Long id) {
        try {
            Article articleOfId = articleRepository.findById(id).get();
            return articleOfId;
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Article with the id [%d] was found in the database.", id));
        }
    }

    /**
     * Delete the Article of passed id parameter
     * @param id represents the ID of the article we wish to delete
     * @return Confirmation message of article deletion
     */
    @Override
    public String deleteArticleOfId(Long id) {
        try {
            articleRepository.deleteById(id);
            return "Article of id=" + id + " is deleted";
        } catch(Exception ex) {
            throw new NotFoundException("Article of id=" + id + " is not found. Hence, not deleted");
        }


    }

    /**
     * Add the passed article to the DB
     * @param newArticle represents the newly created article
     * @return The newly created article to the caller of the method
     */
    @Override
    public Article addNewArticle(Article newArticle) {
        try {

            Article newAddedArticle = articleRepository.save(newArticle);
            return newAddedArticle;

        } catch(MissingFieldException ex) {
            throw new MissingFieldException(ex.getMessage());
        }
    }
}
