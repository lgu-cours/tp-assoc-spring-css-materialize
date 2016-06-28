package controller;

import bean.ListeAdherents;
import bean.ListeArticles;
import bean.ListePays;
import common.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ughostephan on 27/04/2016.
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    public String index(ModelMap model, HttpServletRequest request) {
        // Initialisation de la session
        HttpSession session = request.getSession(true); // create if doesn't exist

        if (session != null) {
            // Init values in session
            session.setAttribute(Const.LISTE_ADHERENTS, ListeAdherents.getList());
            session.setAttribute(Const.LISTE_ARTICLES, ListeArticles.getList());
            session.setAttribute(Const.LISTE_PAYS, ListePays.getList());
        }

        if (session != null && session.getAttribute(Const.ADHERENT) == null) {
            return "redirect:/login";
        }

        return "index";
    }
}
