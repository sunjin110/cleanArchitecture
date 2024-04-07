package info.sunjin.cleanArchitecture.infrastructure.dto;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class ArticleDto {

    public ArticleDto() {
        super();
    }

    public ArticleDto(ArticleModel article) {
        this.id = article.id();
        this.title = article.title();
        this.body = article.body();
        this.createdAt = article.createdAt();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    public String title;

    public String body;

    public LocalDateTime createdAt;

    public ArticleModel toModel() {
        return new ArticleModel(this.id, this.title, this.body, this.createdAt);
    }
}
