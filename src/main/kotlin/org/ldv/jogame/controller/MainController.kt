package org.ldv.jogame.controller

import org.ldv.jogame.model.dao.JeuxDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.security.core.Authentication



@Controller
class MainController (val jeuxDAO: JeuxDAO) {


    @GetMapping("/Jogame")
    fun home(): String {
        return "index"
    }

    @GetMapping("/Jogame/compte")
    fun compte(): String {
        return "compte"
    }

    @GetMapping("/Jogame/panier")
    fun panier(): String {
        return "panier"
    }

    @GetMapping("/Jogame/inscription")
    fun inscription(): String {
        return "inscription"
    }

    @GetMapping("/Jogame/index")
    fun index(): String {
        return "index"
    }

    @GetMapping("/Jogame/Support")
    fun support(): String {
        return "Support"
    }

    @GetMapping("/Jogame/tendance")
    fun tendance(): String {
        return "tendance"  // templates/tendance.html
    }
    @GetMapping("/Jogame/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }


    @GetMapping("/Jogame/admin/indexjeux")
    fun getTrendingGames(model: Model): String {
        val jeux = jeuxDAO.findAll()
        model.addAttribute("jeux",jeux)
        return "pageAdmin/Jeux/indexjeux"
    }
    @Controller
    class ProfilController {

        @GetMapping("/Jogame/profil")
        fun profile(authentication: Authentication): String {

            // Récupération des rôles de l'utilisateur
            val roles = authentication.authorities.map { it.authority }

            // Redirection si admin
            if ("ROLE_ADMIN" in roles) {
                return "redirect:/Jogame/admin/indexjeux"
            }

            // Sinon affichage de la page profil
            return "pageClient/profil"
        }
    }

}