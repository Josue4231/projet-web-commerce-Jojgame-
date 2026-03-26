package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.Panier
import org.springframework.data.jpa.repository.JpaRepository

interface PanierDAO : JpaRepository<Panier, Long> {
}