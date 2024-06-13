package com.softgr5.microservicio.viajes.repos;

import com.softgr5.microservicio.viajes.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajesRepository extends JpaRepository<Viajes, Long> {
}
