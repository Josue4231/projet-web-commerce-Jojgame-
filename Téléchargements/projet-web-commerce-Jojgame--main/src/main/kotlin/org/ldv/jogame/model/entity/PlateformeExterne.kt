package org.ldv.jogame.model.entity

import jakarta.persistence.*

@Entity
@DiscriminatorValue("PLATformeExterne")

class PlateformeExterne(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, unique = true)
    var nom: String,

    @Column(nullable = false)
    var urlActivation: String
) {

    @Transient
    fun activerCle(cle: String) {
        // logique non persistée
    }
}
