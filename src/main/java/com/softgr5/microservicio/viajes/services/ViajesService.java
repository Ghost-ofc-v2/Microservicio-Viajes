package com.softgr5.microservicio.viajes.services;

import com.softgr5.microservicio.viajes.DTO.PublicarViaje1;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje2;

public interface ViajesService {

    Long publicarViajev1(String jwtToken, PublicarViaje1 publicarViaje1);
    String publicarViaje2(String jwtToken, Long viajeId, PublicarViaje2 publicarViaje2);
}
