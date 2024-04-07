package info.sunjin.cleanArchitecture.presenteter.response.article;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;

import java.time.LocalDateTime;

public record Article(String id, String title, String body, LocalDateTime createdAt) {
    public Article(ArticleModel article) {
        this(article.id(), article.title(), article.body(), article.createdAt());
    }
}
