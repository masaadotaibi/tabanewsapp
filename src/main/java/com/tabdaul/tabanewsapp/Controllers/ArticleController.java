package com.tabdaul.tabanewsapp.Controllers;

import com.tabdaul.tabanewsapp.Entities.Article;
import com.tabdaul.tabanewsapp.services.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleServiceImpl.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {

        Article articleOfId = articleServiceImpl.getArticleById(id);

        return new ResponseEntity<>(articleOfId, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Article> addNewArticle(@Valid @RequestBody Article newArticle) {
        Article addedArticle = articleServiceImpl.addNewArticle(newArticle);
        return new ResponseEntity<>(addedArticle, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        String deletionMessage = articleServiceImpl.deleteArticleOfId(id);

        return new ResponseEntity<>(deletionMessage, HttpStatus.NO_CONTENT);
    }
}
