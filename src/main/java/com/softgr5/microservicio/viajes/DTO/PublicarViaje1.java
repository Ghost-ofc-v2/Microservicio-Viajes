package com.softgr5.microservicio.viajes.DTO;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicarViaje1 {

    private String departamentodestino;
    private String ciudaddestino;
    private String direcciondestino;
    private String paisdestino;


    private String departamentoorigen;
    private String ciudadorigen;
    private String direccionorigen;
    private String paisorigen;


    public String getDepartamentodestino() {
        return departamentodestino;
    }

    public void setDepartamentodestino(String departamentodestino) {
        this.departamentodestino = departamentodestino;
    }

    public String getCiudaddestino() {
        return ciudaddestino;
    }

    public void setCiudaddestino(String ciudaddestino) {
        this.ciudaddestino = ciudaddestino;
    }

    public String getDirecciondestino() {
        return direcciondestino;
    }

    public void setDirecciondestino(String direcciondestino) {
        this.direcciondestino = direcciondestino;
    }

    public String getPaisdestino() {
        return paisdestino;
    }

    public void setPaisdestino(String paisdestino) {
        this.paisdestino = paisdestino;
    }

    public String getDepartamentoorigen() {
        return departamentoorigen;
    }

    public void setDepartamentoorigen(String departamentoorigen) {
        this.departamentoorigen = departamentoorigen;
    }

    public String getCiudadorigen() {
        return ciudadorigen;
    }

    public void setCiudadorigen(String ciudadorigen) {
        this.ciudadorigen = ciudadorigen;
    }

    public String getDireccionorigen() {
        return direccionorigen;
    }

    public void setDireccionorigen(String direccionorigen) {
        this.direccionorigen = direccionorigen;
    }

    public String getPaisorigen() {
        return paisorigen;
    }

    public void setPaisorigen(String paisorigen) {
        this.paisorigen = paisorigen;
    }
}
