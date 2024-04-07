package info.sunjin.cleanArchitecture.presenteter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class Web {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/article")
    public ModelAndView displayArticle(Map<String, Object> model) {
        return null;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
