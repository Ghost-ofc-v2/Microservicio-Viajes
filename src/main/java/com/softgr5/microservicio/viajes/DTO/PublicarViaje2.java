package com.softgr5.microservicio.viajes.DTO;

import lombok.*;

import java.time.LocalDateTime;


public class PublicarViaje2 {

    private String marcaAuto;
    private String modeloAuto;
    private String placaAuto;
    private String colorAuto;

    private Integer pasajeros;
    private Float precio;
    private LocalDateTime fechaHoraSalida;

    public PublicarViaje2(String marcaAuto, String placaAuto, String modeloAuto, String colorAuto, Integer pasajeros, Float precio, LocalDateTime fechaHoraSalida) {
        this.marcaAuto = marcaAuto;
        this.placaAuto = placaAuto;
        this.modeloAuto = modeloAuto;
        this.colorAuto = colorAuto;
        this.pasajeros = pasajeros;
        this.precio = precio;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public String getColorAuto() {
        return colorAuto;
    }

    public void setColorAuto(String colorAuto) {
        this.colorAuto = colorAuto;
    }

    public String getPlacaAuto() {
        return placaAuto;
    }

    public void setPlacaAuto(String placaAuto) {
        this.placaAuto = placaAuto;
    }

    public Integer getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Integer pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
}
