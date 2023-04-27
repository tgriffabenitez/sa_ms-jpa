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
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="banco", nullable = false)
    private String banco;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="tipo", nullable = false)
    private String tipo;

    @OneToOne(mappedBy = "cuentaBancaria")
    @PrimaryKeyJoinColumn
    private Empleado empleado;
}
