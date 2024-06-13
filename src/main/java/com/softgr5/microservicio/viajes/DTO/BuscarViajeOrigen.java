package com.softgr5.microservicio.viajes.DTO;

import lombok.*;

import java.time.LocalDate;


public class BuscarViajeOrigen {
    private String ciudadorigen;
    private String ciudaddestino;
    private LocalDate fechaorigen;


    public BuscarViajeOrigen(String ciudadorigen, String ciudaddestino, LocalDate fechaorigen) {
        this.ciudadorigen = ciudadorigen;
        this.ciudaddestino = ciudaddestino;
        this.fechaorigen = fechaorigen;
    }

    public String getCiudadorigen() {
        return ciudadorigen;
    }

    public void setCiudadorigen(String ciudadorigen) {
        this.ciudadorigen = ciudadorigen;
    }

    public String getCiudaddestino() {
        return ciudaddestino;
    }

    public void setCiudaddestino(String ciudaddestino) {
        this.ciudaddestino = ciudaddestino;
    }

    public LocalDate getFechaorigen() {
        return fechaorigen;
    }

    public void setFechaorigen(LocalDate fechaorigen) {
        this.fechaorigen = fechaorigen;
    }
}
