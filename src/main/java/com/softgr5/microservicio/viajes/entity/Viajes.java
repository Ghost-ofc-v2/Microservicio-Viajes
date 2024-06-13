package com.softgr5.microservicio.viajes.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_viajes;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;
    @Column(name = "fecha_hora_llegada")
    private LocalDateTime fechaHoraLlegada;
    private Float costoViaje;
    private Integer totalAsientos;
    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer asientosReservados;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean disponible;

    private Long conductorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalleviajeorigen_id")
    private ViajeOrigen viajeOrigen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalleviajedestino_id")
    private ViajeDestino viajeDestino;


    public Long getId_viajes() {
        return id_viajes;
    }

    public void setId_viajes(Long id_viajes) {
        this.id_viajes = id_viajes;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public LocalDateTime getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Float getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(Float costoViaje) {
        this.costoViaje = costoViaje;
    }

    public Integer getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(Integer totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public Integer getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(Integer asientosReservados) {
        this.asientosReservados = asientosReservados;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }

    public ViajeOrigen getViajeOrigen() {
        return viajeOrigen;
    }

    public void setViajeOrigen(ViajeOrigen viajeOrigen) {
        this.viajeOrigen = viajeOrigen;
    }

    public ViajeDestino getViajeDestino() {
        return viajeDestino;
    }

    public void setViajeDestino(ViajeDestino viajeDestino) {
        this.viajeDestino = viajeDestino;
    }
}
