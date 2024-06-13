package com.softgr5.microservicio.viajes.services;

import com.softgr5.microservicio.viajes.DTO.BuscarViajeOrigen;
import com.softgr5.microservicio.viajes.entity.Viajes;

import java.util.List;

public interface ViajeOrigenService {

    List<Viajes> buscarViajeOrigen(BuscarViajeOrigen buscarViajeOrigen);
}
