package org.ldv.jogame.service

import org.ldv.jogame.model.dao.*
import org.ldv.jogame.model.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val avisDAO: AvisDAO,
    private val clientDAO: ClientDAO,
    private val commandeDAO: CommandeDAO,
    private val jeuxDAO: JeuxDAO,
    private val lignePanierDAO: LignePanierDAO,
    private val paiementDAO: PaiementDAO,
    private val panierDAO: PanierDAO,

    private val plateformeExterneDAO: PlateformeExterneDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Si la base contient déjà des utilisateurs, on ne fait rien
        if (utilisateurDAO.count() > 0) {
            println("Données déjà présentes, initialisation ignorée.")
            return
        }

        println("Injection des données de test...")

        // === UTILISATEURS ===
        val Client = Client(
            id = null,
            nom = "Durand",
            prenom = "Pierre",
            email = "client@client.com",
            motDePasse = passwordEncoder.encode("client123"),

        )


        val admin = Administrateur(
            id = null,
            nom = "Admin",
            prenom = "Jean",
            email = "admin@admin.com",
            motDePasse = passwordEncoder.encode("admin123"),



        )



        utilisateurDAO.saveAll(listOf(Client, admin))

        // === JEUX ===
        val jeu1 = Jeux(
            id = null,
            titre = "elden ring",
            description = "Jeux from software",
            prix = 59.99f,
            categorie = "Action",
            plateformeCompatible = "PC",
            cleActivation = "ABC123XYZ",
            videoGameplay = "videos/sekiro.mp4",
            imageJeu = "images/sekiro.jpg"
        )

        val jeu2 = Jeux(
            id = null,
            titre = "Destiny 2",
            description = "Jeu de guerre online ou solos",
            prix = 40.00f,
            categorie = "Action",
            plateformeCompatible = "PC",
            cleActivation = "DEF456GHI",
            videoGameplay = "videos/destiny2.mp4",
            imageJeu = "images/destiny.jpg"
        )

        val jeu3 = Jeux(
            id = null,
            titre = "Batman",
            description = "Jeu combat avec des super mechants",
            prix = 10.00f,
            categorie = "Action",
            plateformeCompatible = "STEAM",
            cleActivation = "JKL789OPI",
            videoGameplay = "videos/batman.mp4",
            imageJeu = "img/batman.jpeg"
        )
        val jeu4=Jeux(
            id=null,
            titre = "Ghost of Yotei",
            description = "Jeu samourai",
            prix = 30.00f,
            categorie = "Action",
            plateformeCompatible = "STEAM",
            cleActivation = "KMNOPDF442",
            videoGameplay = "videos/ghostofyotei.mp4",
            imageJeu = "img/Ghostyotei.jpg"
        )
        val jeux = listOf(jeu1, jeu2, jeu3, jeu4)

        jeuxDAO.save(jeu1)
        jeuxDAO.save(jeu2)
        jeuxDAO.save(jeu3)
        jeuxDAO.save(jeu4)


        // === AVIS ===
        val avis1 = Avis(
            id = null,
            note = 5,
            commentaire = "Excellent jeu !",
            dateAvis = LocalDate.parse("2025-11-17")
        )
        val avis2 = Avis(
            id = null,
            note = 4,
            commentaire = "Très bon gameplay",
            dateAvis = LocalDate.parse("2025-11-18")
        )

        val avis3 = Avis(
            id = null,
            note = 3,
            commentaire = "Pas mal mais quelques bugs",
            dateAvis = LocalDate.parse("2025-11-19")
        )



        avisDAO.save(avis1)
        avisDAO.save(avis2)
        avisDAO.save(avis3)





        // === PANIER ===
        val panier = Panier(
            id = null,
            dateCreation = LocalDate.parse("2025-11-17"),
            total = 0f,
            client = Client
        )

        panierDAO.save(panier)

        // === COMMANDE ===
        val commande = Commande(
            id = null,
            dateCommande = LocalDate.parse("2025-11-17"),
            montantTotal = 59.99f,
            statut = "EN_COURS"
        )

        commandeDAO.save(commande)

        println("Données initiales insérées !")
    }
}
