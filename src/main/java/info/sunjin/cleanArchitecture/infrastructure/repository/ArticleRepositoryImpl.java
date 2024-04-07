package info.sunjin.cleanArchitecture.infrastructure.repository;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;
import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import info.sunjin.cleanArchitecture.domain.repository.Paging;
import info.sunjin.cleanArchitecture.infrastructure.dto.ArticleDto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    @Autowired
    ArticleJpaRepository articleRepo;

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public ArticleModel getById(String id) {
        var articleDto = this.articleRepo.getReferenceById(id);
        return articleDto.toModel();
    }

    @Override
    public void deleteById(String id) {
        this.articleRepo.deleteById(id);
    }

    @Override
    public void save(ArticleModel article) {
        this.articleRepo.save(new ArticleDto(article));
    }

    @Override
    public List<ArticleModel> find(Paging paging) {
        @SuppressWarnings("unchecked")
        List<ArticleDto> articles = this.entityManager.createNativeQuery("select * from articles limit :limit offset :offset", ArticleDto.class).
            setParameter("offset", paging.offset()).
            setParameter("limit", paging.limit()).
            getResultList();
        return articles.stream().map(ArticleDto::toModel).toList();
    }

    @Override
    public boolean exists(String id) {
        return this.articleRepo.existsById(id);
    }
}
