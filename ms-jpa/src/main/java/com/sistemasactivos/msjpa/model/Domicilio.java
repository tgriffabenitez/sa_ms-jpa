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
@Table(name="domicilio")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="calle", nullable = false)
    private String calle;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="ciudad", nullable = false)
    private String ciudad;

    @OneToOne(mappedBy = "domicilio")
    private Empleado empleado;

}
