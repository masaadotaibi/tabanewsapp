package com.tabdaul.tabanewsapp;

import com.tabdaul.tabanewsapp.Entities.Article;
import com.tabdaul.tabanewsapp.repositories.ArticleRepository;
import com.tabdaul.tabanewsapp.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class ArticleServiceTest {

    @MockBean
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    @TestConfiguration
    static class ArticleServiceContextConfiguration {
        @Bean
        public ArticleService articleService() {
            return new ArticleService();
        }
    }

    @Test
    public void findAllTest() {

        // Arrange
        Article article1 = new Article(1L, "Article 1", "Body 1");
        Article article2 = new Article(2L, "Article 2", "Body 2");
        List<Article> data = Arrays.asList(article1, article2);

        // Act
        given(articleRepository.findAll()).willReturn(data);
        List<Article> result = articleService.findAll();

        // Assert
        assertThat(result).hasSize(2).contains(article1, article2);
    }

    @Test
    public void getArticleById() {

        // Arrange
        Article article = new Article(1L, "Article 1", "Body 1");

        // Act
        given(articleRepository.findById(anyLong())).willReturn(Optional.ofNullable(article));
        Article result = articleService.getArticleById(1L);

        // Assert
        assertThat(result.getTitle()).containsIgnoringCase("article");
    }

}
