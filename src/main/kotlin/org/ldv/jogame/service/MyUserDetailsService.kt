package org.ldv.jogame.service

import org.ldv.jogame.model.dao.UtilisateurDAO
import org.ldv.jogame.model.entity.Administrateur
import org.ldv.jogame.model.entity.Client
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(private val utilisateurDAO: UtilisateurDAO) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {


        val utilisateur = utilisateurDAO.findByEmail(username)
            ?: throw UsernameNotFoundException("User not found")


        var leRole = ""
        if(utilisateur is Administrateur){
            leRole = "ADMIN"
        }
        else if(utilisateur is Client){
            leRole ="CLIENT"
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(utilisateur.email)   // Identifiant de connexion
            .password(utilisateur.motDePasse)         // Mot de passe hashé
            .roles(leRole)                     // Rôle(s) attribué(s)
            .build()
    }
}

