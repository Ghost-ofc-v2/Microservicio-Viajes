package com.softgr5.microservicio.viajes.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.softgr5.microservicio.viajes.DynamoConfig.LocalDateTimeConverter;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Viajes")
@Builder
@DynamoDBDocument
public class Viajes {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id_viajes;

    @DynamoDBAttribute(attributeName = "fecha_hora_salida")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaHoraSalida;
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaHoraLlegada;
    @DynamoDBAttribute
    private Float costoViaje;
    @DynamoDBAttribute
    private Integer totalAsientos;
    @DynamoDBAttribute
    private Integer asientosReservados = 0;
    @DynamoDBAttribute
    private Boolean disponible = true;
    @DynamoDBAttribute
    private String conductorId;

    @DynamoDBAttribute(attributeName = "viaje_origen")
    private String viajeOrigen;

    @DynamoDBAttribute(attributeName = "viaje_destino")
    private String viajeDestino;

    public String getId_viajes() {
        return id_viajes;
    }

    public void setId_viajes(String id_viajes) {
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

    public Integer getAsientosReservados() {
        return asientosReservados;
    }

    public void setAsientosReservados(Integer asientosReservados) {
        this.asientosReservados = asientosReservados;
    }

    public Integer getTotalAsientos() {
        return totalAsientos;
    }

    public void setTotalAsientos(Integer totalAsientos) {
        this.totalAsientos = totalAsientos;
    }

    public String getConductorId() {
        return conductorId;
    }

    public void setConductorId(String conductorId) {
        this.conductorId = conductorId;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getViajeDestino() {
        return viajeDestino;
    }

    public void setViajeDestino(String viajeDestino) {
        this.viajeDestino = viajeDestino;
    }

    public String getViajeOrigen() {
        return viajeOrigen;
    }

    public void setViajeOrigen(String viajeOrigen) {
        this.viajeOrigen = viajeOrigen;
    }
}
