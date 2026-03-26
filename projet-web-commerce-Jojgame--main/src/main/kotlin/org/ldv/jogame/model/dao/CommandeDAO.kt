package org.ldv.jogame.model.dao


import org.ldv.jogame.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository

interface CommandeDAO : JpaRepository<Commande, Long> {
}