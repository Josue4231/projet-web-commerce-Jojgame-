package org.ldv.jogame.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@DiscriminatorValue("PAIEMENT")

class Paiement(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var methode: String,

    @Column(nullable = false)
    var montant: Float,

    @Column(nullable = false)
    var datePaiement: LocalDate, // LocalDate plus sûr que String

    @Column(nullable = false)
    var statut: String,

    // Optionnel : relation avec une commande
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
) {

    @Transient
    fun effectuerPaiement() {
        // logique non persistée
    }

    @Transient
    fun verifierPaiement() {
        // logique non persistée
    }
}

