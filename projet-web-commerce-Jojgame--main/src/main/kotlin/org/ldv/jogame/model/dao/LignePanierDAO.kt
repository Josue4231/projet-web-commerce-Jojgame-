package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.LignePanier
import org.springframework.data.jpa.repository.JpaRepository

interface LignePanierDAO : JpaRepository<LignePanier, Long> {
}