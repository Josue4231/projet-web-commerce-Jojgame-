package org.ldv.jogame.model.dao


import org.ldv.jogame.model.entity.Jeux
import org.springframework.data.jpa.repository.JpaRepository

interface JeuxDAO : JpaRepository<Jeux, Long> {
}