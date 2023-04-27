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
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    // relacion uno a uno "comun"
    @OneToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    // relacion uno a uno compartiendo id
    @OneToOne
    @MapsId
    @JoinColumn(name="cuenta_bancaria_id")
    private CuentaBancaria cuentaBancaria;

    // relacion uno a uno con tabla intermedia
    @OneToOne
    @JoinTable(name = "empleado_contrato",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "contrato_id"))
    private Contrato contrato;
}
