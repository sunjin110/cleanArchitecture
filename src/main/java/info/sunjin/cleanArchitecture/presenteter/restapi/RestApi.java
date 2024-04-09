package info.sunjin.cleanArchitecture.presenteter.restapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApi {
    private static final Logger logger = LogManager.getLogger(RestApi.class);

    @GetMapping("/greeting")
    public String sayHello() {
        System.out.println("================ ここだよ");
        return "Hello World";
    }
}
