package com.market.her.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idUsuario;
    @Column(name = "usuario_login")
    private String nomUsuario;
    private String nombre;
    private String estado;
    private String contrasenia;


}
