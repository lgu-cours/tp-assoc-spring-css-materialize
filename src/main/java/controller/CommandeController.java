package controller;

import bean.Article;
import bean.Commande;
import bean.ListeArticles;
import common.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by ughostephan on 27/04/2016.
 */
@Controller
public class CommandeController {

    @RequestMapping(value="/commande",  method= RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Commande commande = new Commande();

        if (session.getAttribute(Const.COMMANDE) != null) {
            commande = (Commande) session.getAttribute(Const.COMMANDE);
        }

        model.addAttribute("articles", commande.getListe());
        return "commande";
    }

    @RequestMapping(value="/commande/{code}",  method= RequestMethod.GET)
    public String commanderUnArticle(ModelMap model, HttpServletRequest request,
                                     @PathVariable("code") String code_article) {

        HttpSession session = request.getSession();
        Commande commande = new Commande();

        if (session.getAttribute(Const.COMMANDE) != null) {
            commande = (Commande) session.getAttribute(Const.COMMANDE);
        }

        if (StringUtils.isEmpty(code_article)) {
            model.addAttribute("error", "Erreur, le code de l'article à commander est manquant");
            return "redirect:/articles";
        }

        ArrayList<Article> articles = (ArrayList<Article>) session.getAttribute(Const.LISTE_ARTICLES);
        Article articleACommander = ListeArticles.chercherArticle(articles, code_article);

        if (articleACommander != null) {
            commande.commanderArticle(articleACommander);
            session.setAttribute(Const.COMMANDE, commande);
            return "redirect:/commande";
        } else {
            model.addAttribute("error", "Erreur, le code de l'article à commander est inconnu");
            return "redirect:/articles";
        }
    }

    @RequestMapping(value="/delete_commande",  method= RequestMethod.POST)
    public String supprimerUnArticle(HttpServletRequest request) {

        HttpSession session = request.getSession(true);

        if (session.getAttribute(Const.COMMANDE) != null) {
            session.removeAttribute(Const.COMMANDE);
        }

        return "redirect:/";
    }
}
