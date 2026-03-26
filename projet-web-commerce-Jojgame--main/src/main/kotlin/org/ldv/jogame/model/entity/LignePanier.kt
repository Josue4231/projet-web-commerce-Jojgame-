package org.ldv.jogame.model.entity

import jakarta.persistence.*

@Entity
@DiscriminatorValue("LIGNE_PANIER")

class LignePanier(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panier_id", nullable = false)
    var panier: Panier? = null,

    @Column(nullable = false)
    var quantite: Int,

    @Column(nullable = false)
    var sousTotal: Float,

    // Optionnel : lien avec un jeu
    @ManyToOne
    @JoinColumn(name = "jeu_id")
    var jeu: Jeux? = null,

    // Optionnel : lien avec une commande
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
)
