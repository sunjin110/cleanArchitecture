package info.sunjin.cleanArchitecture.usecase;

import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleUsecase {
    @Autowired
    ArticleRepository articleRepo;

}
