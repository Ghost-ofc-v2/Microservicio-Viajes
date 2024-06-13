package com.softgr5.microservicio.viajes.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "viajeorigen")
public class ViajeOrigen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idviajeorigen;

    private String departamentoorigen;
    private String ciudadorigen;
    private String direccionorigen;
    private String paisorigen;
    private String latitudorigen;
    private String longitudorigen;


    @OneToOne(mappedBy = "viajeOrigen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Viajes viaje;

    public Long getIdviajeorigen() {
        return idviajeorigen;
    }

    public void setIdviajeorigen(Long idviajeorigen) {
        this.idviajeorigen = idviajeorigen;
    }

    public String getDepartamentoorigen() {
        return departamentoorigen;
    }

    public void setDepartamentoorigen(String departamentoorigen) {
        this.departamentoorigen = departamentoorigen;
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

    public String getCiudadorigen() {
        return ciudadorigen;
    }

    public void setCiudadorigen(String ciudadorigen) {
        this.ciudadorigen = ciudadorigen;
    }

    public Viajes getViaje() {
        return viaje;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }

    public String getLatitudorigen() {
        return latitudorigen;
    }

    public void setLatitudorigen(String latitudorigen) {
        this.latitudorigen = latitudorigen;
    }

    public String getLongitudorigen() {
        return longitudorigen;
    }

    public void setLongitudorigen(String longitudorigen) {
        this.longitudorigen = longitudorigen;
    }

    @Override
    public String toString() {
        return "ViajeOrigen{" +
                "idviajeorigen=" + idviajeorigen +
                ", paisorigen='" + paisorigen + '\'' +
                ", latitudorigen=" + latitudorigen +
                ", longitudorigen=" + longitudorigen +
                // No incluir 'viaje' para evitar recursión
                '}';
    }
}
