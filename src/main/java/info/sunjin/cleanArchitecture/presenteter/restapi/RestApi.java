package info.sunjin.cleanArchitecture.presenteter.restapi;

import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
    private static final Logger logger = LogManager.getLogger(RestApi.class);

    @Autowired
    ArticleRepository articleRepo;

    @GetMapping("/greeting")
    public String sayHello() {
        System.out.println("================ ここだよ");
        return "Hello World";
    }
}
