package org.ldv.jogame.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@DiscriminatorValue("COMMANDE")

class Commande(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column(nullable = false)
    var dateCommande: LocalDate, // plus sûr que String pour manipuler les dates

    @Column(nullable = false)
    var montantTotal: Float,

    @Column(nullable = false)
    var statut: String
) {

    @Transient
    fun validerCommande() {
        // Méthode non persistée
    }
}

