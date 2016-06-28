package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ughostephan on 27/04/2016.
 */
@Controller
public class ArticleController {

    @RequestMapping("/articles")
    public String index() {
        return "articles";
    }
}
