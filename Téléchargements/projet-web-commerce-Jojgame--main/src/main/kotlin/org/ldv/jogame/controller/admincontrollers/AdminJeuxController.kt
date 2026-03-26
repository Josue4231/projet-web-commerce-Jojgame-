package org.ldv.jogame.controller.admincontrollers

import org.ldv.jogame.model.dao.JeuxDAO
import org.ldv.jogame.model.entity.Jeux
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminJeuxController(
    private val jeuxDAO: JeuxDAO
) {

    /**
     * Affiche la liste des jeux pour l'administration
     */
    @GetMapping("/Jogame/admin/Jeux")
    fun index(model: Model): String {
        val jeux = jeuxDAO.findAll()   // récupère tous les jeux
        model.addAttribute("jeux", jeux)
        return "pageAdmin/Jeux/indexjeux"
    }
}





