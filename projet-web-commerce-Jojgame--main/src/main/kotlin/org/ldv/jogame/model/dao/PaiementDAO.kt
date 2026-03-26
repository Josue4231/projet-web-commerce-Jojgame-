package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.Paiement
import org.springframework.data.jpa.repository.JpaRepository

interface PaiementDAO : JpaRepository<Paiement, Long> {
}