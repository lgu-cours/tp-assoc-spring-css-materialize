package controller;

import bean.Adherent;
import bean.ListeAdherents;
import common.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ughostephan on 27/04/2016.
 */
@Controller
public class AdherentController {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String getLogin(ModelMap model) {
        return "login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String postLogin(ModelMap model, HttpServletRequest request,
                       @RequestParam(value="login", defaultValue="" ) String login,
                       @RequestParam(value="password", defaultValue="" ) String password) {

        HttpSession session = request.getSession();

        if (session.getAttribute(Const.ADHERENT) != null) {
            model.addAttribute("error", "Vous êtes déjà connecté");
            System.out.println("Vous êtes déjà connecté");
            return "redirect:/";
        }

        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            model.addAttribute("error", "Des champs sont manquants");
            System.out.println("Des champs sont manquants");
            return "login";
        }

        Adherent loggedUser = null;
        ArrayList<Adherent> listAdherent = (ArrayList<Adherent>) session.getAttribute(Const.LISTE_ADHERENTS);

        for (final Adherent a : listAdherent) {
            if (a.getIdent().equals(login) && a.getMotpasse().equals(password)) {
                loggedUser = a;
                break;
            }
        }

        if (loggedUser != null) {
            session.setAttribute(Const.ADHERENT, loggedUser);
            System.out.println("connection OK");
            return "redirect:/";
        } else {
            model.addAttribute("error", "Mauvais password");
            System.out.println("Mauvais password");
            return "login";
        }
    }

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public String getRegister(ModelMap model) {
        return "register";
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String postRegister(ModelMap model, HttpServletRequest request,
                       @RequestParam(value="login", defaultValue = "") String login,
                       @RequestParam(value="password", defaultValue = "") String password,
                       @RequestParam(value="password_confirm", defaultValue = "") String password_confirm,
                       @RequestParam(value="nom", defaultValue = "") String nom,
                       @RequestParam(value="prenom", defaultValue = "") String prenom,
                       @RequestParam(value="adresse", defaultValue = "") String adresse,
                       @RequestParam(value="codePostal", defaultValue = "") String codePostal,
                       @RequestParam(value="ville", defaultValue = "") String ville,
                       @RequestParam(value="pays", defaultValue = "") String pays) {

        HttpSession session = request.getSession();

        if (StringUtils.isEmpty(login)
                || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(password_confirm)
                || StringUtils.isEmpty(nom)
                || StringUtils.isEmpty(prenom)) {
            model.addAttribute("error", "Des champs sont manquants");
            return "register";
        }

        if (!password.equals(password_confirm)) {
            model.addAttribute("error", "Le password de confirmation n'est pas correct");
            return "register";
        }

        if (codePostal.length() > 5) {
            model.addAttribute("error", "Le code postal est incorrect");
            return "register";
        }

        Adherent adherent = new Adherent(nom,prenom,adresse,codePostal,ville,pays,login,password);

        ArrayList<Adherent> listeAdherents = (ArrayList<Adherent>) session.getAttribute(Const.LISTE_ADHERENTS);
        listeAdherents.add(adherent);

        session.removeAttribute(Const.LISTE_ADHERENTS);
        session.setAttribute(Const.LISTE_ADHERENTS, listeAdherents);
        session.setAttribute(Const.ADHERENT, adherent);
        return "redirect:/";
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Const.ADHERENT);
        return "redirect:/";
    }
}
