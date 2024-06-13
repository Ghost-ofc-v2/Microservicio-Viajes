package com.softgr5.microservicio.viajes.services.impl;

import com.softgr5.microservicio.viajes.DTO.BuscarViajeOrigen;
import com.softgr5.microservicio.viajes.entity.Viajes;
import com.softgr5.microservicio.viajes.repos.ViajeOrigenRepository;
import com.softgr5.microservicio.viajes.services.ViajeOrigenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ViajeOrigenImpl implements ViajeOrigenService {
    
    private ViajeOrigenRepository viajeOrigenRepository;

    @Autowired
    public ViajeOrigenImpl(ViajeOrigenRepository viajeOrigenRepository) {
        this.viajeOrigenRepository = viajeOrigenRepository;
    }

    @Override
    public List<Viajes> buscarViajeOrigen(BuscarViajeOrigen buscarViajeOrigen) {
        return viajeOrigenRepository.findViajesWithOrigenAndDestinoByCriteria(buscarViajeOrigen.getCiudadorigen(), buscarViajeOrigen.getCiudaddestino(), buscarViajeOrigen.getFechaorigen());
    }

}
