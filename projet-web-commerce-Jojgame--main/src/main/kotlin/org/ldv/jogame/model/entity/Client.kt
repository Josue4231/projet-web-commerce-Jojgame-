package org.ldv.jogame.model.entity

import jakarta.persistence.*

import jakarta.persistence.*

@Entity
@DiscriminatorValue("CLIENT")
class Client(
    id: Int? = null,
    nom: String,
    prenom: String,
    email: String,
    motDePasse: String,

) : Utilisateur(id, nom, prenom, email, motDePasse) {

    @Transient
    fun ajouterJeuPanier() {}

    @Transient
    fun passerCommande() {}

    @Transient
    fun payerCommande() {}

    @Transient
    fun recevoirCle() {}
}


