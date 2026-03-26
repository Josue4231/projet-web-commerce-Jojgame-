package org.ldv.jogame.controller.admincontrollers

import org.ldv.jogame.model.dao.AvisDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminAvisController(
    private val avisDAO: AvisDAO
) {

    /**
     * Affiche la liste des jeux pour l'administration
     */
    @GetMapping("/Jogame/Admin/Avis")
    fun index(model: Model): String {
        val avis = avisDAO.findAll()   // récupère tous les jeux
        model.addAttribute("avis", avis)
        return "pageAdmin/Avis/indexavis"
    }
}