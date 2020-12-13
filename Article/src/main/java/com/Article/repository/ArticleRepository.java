package com.Article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Article.model.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
