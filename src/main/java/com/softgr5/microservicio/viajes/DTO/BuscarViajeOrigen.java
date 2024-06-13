package com.softgr5.microservicio.viajes.DTO;

import lombok.*;

import java.time.LocalDate;


public class BuscarViajeOrigen {
    private String ciudadorigen;
    private String ciudaddestino;
    private String fechaorigen;


    public BuscarViajeOrigen(String ciudadorigen, String ciudaddestino, String fechaorigen) {
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

    public String getFechaorigen() {
        return fechaorigen;
    }

    public void setFechaorigen(String fechaorigen) {
        this.fechaorigen = fechaorigen;
    }
}
