package info.sunjin.cleanArchitecture.domain.model;

import java.time.LocalDateTime;

public record ArticleModel(String id, String title, String body, LocalDateTime createdAt) {
}
