package info.sunjin.cleanArchitecture.presenteter.restapi;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;
import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import info.sunjin.cleanArchitecture.domain.repository.Paging;
import info.sunjin.cleanArchitecture.presenteter.response.article.Article;
import info.sunjin.cleanArchitecture.presenteter.response.article.ArticleListResponse;
import info.sunjin.cleanArchitecture.presenteter.restapi.middleware.AccessLog;
import info.sunjin.cleanArchitecture.presenteter.restapi.request.article.ArticleCreateRequest;
import info.sunjin.cleanArchitecture.presenteter.restapi.request.article.ArticleUpdateRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestApi {

    private static final Logger logger = LogManager.getLogger(ArticleRestApi.class);

    @Autowired
    ArticleRepository articleRepo;



    @AccessLog
    @PostMapping
    public ResponseEntity<HttpStatus> createArticle(@RequestBody ArticleCreateRequest request) {
        var uuid = UUID.randomUUID();
        var article = new ArticleModel(uuid.toString(), request.title(), request.body(), LocalDateTime.now());
        this.articleRepo.save(article);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @AccessLog
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable String id) {
        this.articleRepo.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @AccessLog
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleModel> getArticle(@PathVariable String id) {
        var article = this.articleRepo.getById(id);
        return ResponseEntity.ok(article);
    }

    @AccessLog
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> putArticle(@PathVariable String id, @RequestBody ArticleUpdateRequest req) {
        if (!this.articleRepo.exists(id)) {
            return ResponseEntity.notFound().build();
        }
        var article = new ArticleModel(id, req.title(), req.body(), LocalDateTime.now());
        this.articleRepo.save(article);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @AccessLog
    @GetMapping
    @ResponseBody
    public ResponseEntity<ArticleListResponse> getArticles(@RequestParam int offset, @RequestParam int limit) {
        var articles = this.articleRepo.find(new Paging(offset, limit)).stream().map(Article::new).toList();
        return ResponseEntity.ok(new ArticleListResponse(articles));
    }
}
