package org.ldv.jogame.model.dao

import org.ldv.jogame.model.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientDAO : JpaRepository<Client, Long> {
}