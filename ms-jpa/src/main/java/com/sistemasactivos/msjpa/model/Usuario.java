package com.sistemasactivos.msjpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 3, nullable = false)
    private Long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Contacto contacto;
}
