package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.PlateformeExterne
import org.springframework.data.jpa.repository.JpaRepository

interface PlateformeExterneDAO : JpaRepository<PlateformeExterne, Long> {
}