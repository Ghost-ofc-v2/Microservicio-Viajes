package com.softgr5.microservicio.viajes.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    private Long id_usuario;
    private String correo;
    private String role;
    private Long conductorId;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getConductorId() {
        return conductorId;
    }

    public void setConductorId(Long conductorId) {
        this.conductorId = conductorId;
    }
}
