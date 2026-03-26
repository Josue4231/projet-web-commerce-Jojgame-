package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.Avis
import org.springframework.data.jpa.repository.JpaRepository

interface AvisDAO : JpaRepository<Avis, Long> {
}