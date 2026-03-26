package org.ldv.jogame.model.entity

import jakarta.persistence.*

@Entity

class Jeux(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var titre: String,

    @Column(nullable = false, length = 1000)
    var description: String,

    @Column(nullable = false)
    var prix: Float,

    @Column(nullable = false)
    var categorie: String,  // éventuellement, tu peux faire une relation ManyToOne avec Categorie

    @Column(nullable = false)
    var plateformeCompatible: String,

    @Column(nullable = false, unique = true)
    var cleActivation: String,

    @Column(nullable = true)
    var videoGameplay: String? = null,

    @Column(nullable = true)
    var imageJeu: String
) {

    @Transient
    fun afficherDetails() {
        // Cette méthode n'est pas persistée
    }
}
