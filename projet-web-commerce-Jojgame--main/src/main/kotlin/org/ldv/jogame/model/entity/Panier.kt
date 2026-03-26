package org.ldv.jogame.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@DiscriminatorValue("PANIER")

class Panier(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @OneToMany(mappedBy = "panier", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lignePanier: MutableList<LignePanier> = mutableListOf(),


    @Column(nullable = false)
    var dateCreation: LocalDate,  // LocalDate préférable à String

    @Column(nullable = false)
    var total: Float,

    // Optionnel : relation avec le client
    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null,

    // Optionnel : liste des lignes du panier
    @OneToMany(mappedBy = "panier", cascade = [CascadeType.ALL], orphanRemoval = true)
    var lignesPanier: MutableList<LignePanier> = mutableListOf()
) {

    @Transient
    fun ajouterJeu() {
        // logique non persistée
    }

    @Transient
    fun supprimerJeu() {
        // logique non persistée
    }

    @Transient
    fun viderPanier() {
        // logique non persistée
    }

    @Transient
    fun calculerTotal() {
        // logique non persistée
    }
}
