package org.ldv.jogame.model.entity



import jakarta.persistence.*

@Entity
@DiscriminatorValue("ADMIN")
class Administrateur(
    id: Int? = null,
    nom: String,
    prenom: String,
    email: String,
    motDePasse: String,

) : Utilisateur(id, nom, prenom, email, motDePasse) {

    @Transient
    fun ajouterJeu() {
        // logique non persistée
    }

    @Transient
    fun modifierJeu() {
        // logique non persistée
    }

    @Transient
    fun supprimerJeu() {
        // logique non persistée
    }

    @Transient
    fun gererUtilisateurs() {
        // logique non persistée
    }

    @Transient
    fun consulterStatistiques() {
        // logique non persistée
    }
}

