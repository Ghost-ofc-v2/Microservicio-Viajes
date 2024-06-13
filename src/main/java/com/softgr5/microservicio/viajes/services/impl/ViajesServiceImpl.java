package com.softgr5.microservicio.viajes.services.impl;


import com.softgr5.microservicio.viajes.DTO.Conductor;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje1;
import com.softgr5.microservicio.viajes.DTO.PublicarViaje2;
import com.softgr5.microservicio.viajes.DTO.Usuario;
import com.softgr5.microservicio.viajes.entity.ViajeDestino;
import com.softgr5.microservicio.viajes.entity.ViajeOrigen;
import com.softgr5.microservicio.viajes.entity.Viajes;
import com.softgr5.microservicio.viajes.reposDynamo.ViajeDestinoRepository;
import com.softgr5.microservicio.viajes.reposDynamo.ViajeOrigenRepository;
import com.softgr5.microservicio.viajes.reposDynamo.ViajesRepository;
import com.softgr5.microservicio.viajes.services.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViajesServiceImpl implements ViajesService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${usuario.service.url}")
    private String usuarioServiceUrl;

    @Value("${usuario.service.url}")
    private String conductorServiceUrl;

    @Value("${usuario.service.url}")
    private String authServiceUrl;

    @Autowired
    private ViajesRepository viajesRepository;

    @Autowired
    private ViajeOrigenRepository viajeOrigenRepository;

    @Autowired
    private ViajeDestinoRepository viajeDestinoRepository;

    @Override
    public String publicarViajev1(String jwtToken, PublicarViaje1 publicarViaje1) {
        try {
            // Obtener correo del usuario autenticado
            String correo = restTemplate.getForObject(authServiceUrl + "/api/usuario/email/" + jwtToken, String.class);

            if (correo == null) {
                throw new UsernameNotFoundException("Usuario no encontrado con el token proporcionado.");
            }

            // Obtener información del usuario
            Usuario usuario = restTemplate.getForObject(usuarioServiceUrl + "/api/usuario/" + correo, Usuario.class);

            if (usuario == null || !usuario.getRole().equals("CONDUCTOR")) {
                throw new SecurityException("Solo los conductores pueden publicar viajes.");
            }

            // Obtener información del conductor
            Conductor conductor = restTemplate.getForObject(conductorServiceUrl + "/api/usuario/" + usuario.getId_usuario() + "/conductor", Conductor.class);
            if (conductor == null) {
                throw new IllegalStateException("No hay un conductor asociado a este usuario.");
            }

            Viajes viajes = new Viajes();
            viajes.setAsientosReservados(0);
            viajes.setDisponible(Boolean.TRUE);
            viajes.setConductorId(conductor.getIdConductor());

            ViajeOrigen viajeOrigen = new ViajeOrigen();
            viajeOrigen.setDireccionorigen(publicarViaje1.getDireccionorigen());
            viajeOrigen.setCiudadorigen(publicarViaje1.getCiudadorigen());
            viajeOrigen.setDepartamentoorigen(publicarViaje1.getDepartamentoorigen());

            ViajeDestino viajeDestino = new ViajeDestino();
            viajeDestino.setDirecciondestino(publicarViaje1.getDirecciondestino());
            viajeDestino.setCiudaddestino(publicarViaje1.getCiudaddestino());
            viajeDestino.setDepartamentodestino(publicarViaje1.getDepartamentodestino());

            // Guardar ViajeOrigen y ViajeDestino
            ViajeOrigen savedViajeOrigen = viajeOrigenRepository.save(viajeOrigen);
            ViajeDestino savedViajeDestino = viajeDestinoRepository.save(viajeDestino);

            viajes.setViajeOrigen(savedViajeOrigen.getIdviajeorigen());
            viajes.setViajeDestino(savedViajeDestino.getIdviajedestino());

            Viajes savedViajes = viajesRepository.save(viajes);

            return "{\"success\": true, \"message\": \""+savedViajes.getId_viajes()+"\"}";
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al publicar el viaje: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al publicar el viaje: " + e.getMessage());
        }
    }

    @Override
    public String publicarViaje2(String jwtToken, String viajeId, PublicarViaje2 publicarViaje2) {
        try {
            // Obtener correo del usuario autenticado
            String correo = restTemplate.getForObject(authServiceUrl + "/api/usuario/email/" + jwtToken, String.class);

            if (correo == null) {
                throw new UsernameNotFoundException("Usuario no encontrado con el token proporcionado.");
            }

            // Obtener información del usuario
            Usuario usuario = restTemplate.getForObject(usuarioServiceUrl + "/api/usuario/" + correo, Usuario.class);

            if (usuario == null || !usuario.getRole().equals("CONDUCTOR")) {
                throw new SecurityException("Solo los conductores pueden publicar viajes.");
            }

            // Obtener el viaje existente
            Viajes viajes = viajesRepository.findById(viajeId)
                    .orElseThrow(() -> new IllegalArgumentException("El viaje no existe"));

            // Obtener información del conductor asociado al viaje
            String conductorId = viajes.getConductorId();

            Conductor conductor = restTemplate.getForObject(conductorServiceUrl + "/api/usuario/conductor/" + conductorId, Conductor.class);
            if (conductor == null) {
                throw new IllegalStateException("El conductor no existe");
            }

            // Actualizar la información del conductor
            conductor.setMarcaAuto(publicarViaje2.getMarcaAuto());
            conductor.setModeloAuto(publicarViaje2.getModeloAuto());
            conductor.setPlacaAuto(publicarViaje2.getPlacaAuto());
            conductor.setColorAuto(publicarViaje2.getColorAuto());

            // Guardar la información del conductor actualizada
            restTemplate.put(conductorServiceUrl + "/api/usuario/conductor/guardar/" + conductorId, conductor);

            // Actualizar la información del viaje
            viajes.setFechaHoraSalida(publicarViaje2.getFechaHoraSalida());
            viajes.setCostoViaje(publicarViaje2.getPrecio());
            viajes.setTotalAsientos(publicarViaje2.getPasajeros());

            // Guardar la información del viaje actualizada
            viajesRepository.save(viajes);

            return "Detalles del conductor actualizados y viaje actualizado exitosamente para el viaje ID: " + viajeId;
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error al comunicarse con el servicio externo: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el viaje: " + e.getMessage());
        }
    }
}