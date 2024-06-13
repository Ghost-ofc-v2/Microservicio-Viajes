package com.softgr5.microservicio.viajes.repos;

import com.softgr5.microservicio.viajes.entity.ViajeDestino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeDestinoRepository extends JpaRepository<ViajeDestino, Long> {
}
