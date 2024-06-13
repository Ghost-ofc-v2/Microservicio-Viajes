package com.softgr5.microservicio.viajes.services;

import com.softgr5.microservicio.viajes.DTO.PublicarViaje1;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje2;

public interface ViajesService {

    String publicarViajev1(String jwtToken, PublicarViaje1 publicarViaje1);
    String publicarViaje2(String jwtToken, String viajeId, PublicarViaje2 publicarViaje2);
}
