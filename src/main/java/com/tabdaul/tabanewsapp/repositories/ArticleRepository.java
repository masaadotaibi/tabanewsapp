package com.tabdaul.tabanewsapp.repositories;


import com.tabdaul.tabanewsapp.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
