package info.sunjin.cleanArchitecture.infrastructure.repository;

import info.sunjin.cleanArchitecture.infrastructure.dto.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<ArticleDto, String> { }
