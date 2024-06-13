package com.softgr5.microservicio.viajes.repos;

import com.softgr5.microservicio.viajes.entity.ViajeOrigen;
import com.softgr5.microservicio.viajes.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ViajeOrigenRepository extends JpaRepository<ViajeOrigen, Long> {

    @Query("SELECT v, vo, vd FROM Viajes v " +
            "JOIN FETCH v.viajeOrigen vo " +
            "JOIN FETCH v.viajeDestino vd " +
            "WHERE vo.ciudadorigen = :ciudadOrigen " +
            "AND vd.ciudaddestino = :ciudadDestino " +
            "AND FUNCTION('DATE', v.fechaHoraSalida) = :fecha")
    List<Viajes> findViajesWithOrigenAndDestinoByCriteria(String ciudadOrigen, String ciudadDestino, LocalDate fecha);
}
