package com.sistemasactivos.msjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 3, nullable = false)
    private Long id;

    @Column(name="rol", nullable = false)
    private String rol;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<Persona> personas;
}
