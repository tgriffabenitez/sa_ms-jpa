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
@Table(name="email")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 3, nullable = false)
    private Long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="telefono")
    private String telefono;

    /*
    * El MapsId sirve para que el id de la tabla contacto sea el mismo que el de la tabla persona,
    * si no lo utilizo, se genera un id nuevo
    */
    @OneToOne
    @MapsId
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
