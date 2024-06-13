package com.softgr5.microservicio.viajes.controllers;

import com.softgr5.microservicio.viajes.DTO.BuscarViajeOrigen;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje1;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje2;
import com.softgr5.microservicio.viajes.configuracion.EncryptionUtil;
import com.softgr5.microservicio.viajes.entity.Viajes;
import com.softgr5.microservicio.viajes.services.ViajeOrigenService;
import com.softgr5.microservicio.viajes.services.ViajesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajesController {

    @Autowired
    ViajesService viajeService;

    @Autowired
    private ViajeOrigenService viajeOrigenService;

    @PostMapping("/publicar-viaje1")
    public ResponseEntity<?> publicarViaje(@RequestHeader("Authorization") String authorizationHeader, @RequestBody @Valid PublicarViaje1 publicarViaje1) {
        try{
            String jwtToken = authorizationHeader.substring(7);

            String jwtToken2 = EncryptionUtil.decrypt(jwtToken);
            String idviaje = viajeService.publicarViajev1(jwtToken2, publicarViaje1);
            String mensajeres = "ID del viaje: " + idviaje + "\n";
            return ResponseEntity.ok(mensajeres);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (NullPointerException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/publicar-viaje2/{viajeId}")
    public ResponseEntity<?> publicarViaje2(@RequestHeader("Authorization") String authorizationHeader, @PathVariable String viajeId,@RequestBody @Valid  PublicarViaje2 publicarViaje2) {
        try {
            String jwtToken = authorizationHeader.substring(7);

            String jwtToken2 = EncryptionUtil.decrypt(jwtToken);

            String message = viajeService.publicarViaje2(jwtToken2, viajeId, publicarViaje2);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException | NullPointerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/buscar-viaje")
    public ResponseEntity<?> buscarviaje(@RequestBody @Valid BuscarViajeOrigen buscarViajeOrigen) {
        List<Viajes> viajes = viajeOrigenService.buscarViajeOrigen(buscarViajeOrigen);
        return ResponseEntity.ok(viajes);
    }
}
