package org.ldv.jogame.model.entity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@DiscriminatorValue("AVIS")
class Avis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var note: Int,

    @Column(nullable = false, length = 1000)
    var commentaire: String,

    @Column(nullable = false)
    var dateAvis: LocalDate,
) {
    @Transient
    fun ajouterAvis() {
        // Méthode non persistée
    }

    @Transient
    fun supprimerAvis() {
        // Méthode non persistée
    }
}
