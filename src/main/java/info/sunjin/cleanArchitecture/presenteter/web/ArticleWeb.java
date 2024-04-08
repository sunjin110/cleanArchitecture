package info.sunjin.cleanArchitecture.presenteter.web;

import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import info.sunjin.cleanArchitecture.domain.repository.Paging;
import info.sunjin.cleanArchitecture.presenteter.web.model.ArticleWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ArticleWeb {

    @Autowired
    ArticleRepository articleRepo;

    @GetMapping("/articles")
    public ModelAndView displayArticle(Map<String, Object> modelMap) {
        var articles = this.articleRepo.find(new Paging(0, 10)).stream().map(ArticleWebModel::new).toList();
        modelMap.put("articles", articles);
        return new ModelAndView("index", modelMap);
    }
}
