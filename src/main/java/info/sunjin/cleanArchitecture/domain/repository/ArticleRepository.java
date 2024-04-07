package info.sunjin.cleanArchitecture.domain.repository;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;

import java.util.List;

public interface ArticleRepository {
    ArticleModel getById(String id);

    void deleteById(String id);

    void save(ArticleModel article);

    List<ArticleModel> find(Paging paging);

    boolean exists(String id);
}
