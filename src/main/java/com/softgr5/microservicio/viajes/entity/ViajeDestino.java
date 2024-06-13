package com.softgr5.microservicio.viajes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viajedestino")
public class ViajeDestino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idviajedestino;

    private String departamentodestino;
    private String ciudaddestino;
    private String direcciondestino;
    private String paisdestino;
    private String latituddestino;
    private String longituddestino;

    @OneToOne(mappedBy = "viajeDestino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Viajes viaje;

    public Long getIdviajedestino() {
        return idviajedestino;
    }

    public void setIdviajedestino(Long idviajedestino) {
        this.idviajedestino = idviajedestino;
    }

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

    public String getPaisdestino() {
        return paisdestino;
    }

    public void setPaisdestino(String paisdestino) {
        this.paisdestino = paisdestino;
    }

    public String getDirecciondestino() {
        return direcciondestino;
    }

    public void setDirecciondestino(String direcciondestino) {
        this.direcciondestino = direcciondestino;
    }

    public String getLongituddestino() {
        return longituddestino;
    }

    public void setLongituddestino(String longituddestino) {
        this.longituddestino = longituddestino;
    }

    public String getLatituddestino() {
        return latituddestino;
    }

    public void setLatituddestino(String latituddestino) {
        this.latituddestino = latituddestino;
    }

    public Viajes getViaje() {
        return viaje;
    }

    public void setViaje(Viajes viaje) {
        this.viaje = viaje;
    }

    @Override
    public String toString() {
        return "ViajeDestino{" +
                "idviajedestino=" + idviajedestino +
                ", paisdestino='" + paisdestino + '\'' +
                ", latituddestino=" + latituddestino +
                ", longituddestino=" + longituddestino +
                // No incluir 'viaje' para evitar recursión
                '}';
    }
}
