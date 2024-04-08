package info.sunjin.cleanArchitecture.presenteter.web.model;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;

public record ArticleWebModel(String id, String title, String body) {

    public ArticleWebModel(ArticleModel article) {
        this(article.id(), article.title(), article.body());
    }
}
