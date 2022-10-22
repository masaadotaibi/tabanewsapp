package com.tabdaul.tabanewsapp.Controllers;

import com.tabdaul.tabanewsapp.Entities.Article;
import com.tabdaul.tabanewsapp.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping({"", "/"})
    public List<Article> getAllArticles() {

        return articleService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {

        Article articleOfId = articleService.getArticleById(id);

        return articleOfId;
    }

    @PostMapping({"", "/"})
    public Article addNewArticle(@RequestBody Article newArticle) {
        if(articleService.addNewArticle(newArticle)) {
            return newArticle;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Article deleteArticle(@PathVariable Long id) {
        Article deletedArticle = articleService.deleteArticleOfId(id);

        return deletedArticle;
    }
}
