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

    /*
    * La anotación @PrimaryKeyJoinColumn indica que la clave primaria de la entidad Empleado se utilizará como clave
    * foránea en la tabla de la entidad CuentaBancaria. Esto significa que la tabla CuentaBancaria tendrá una columna
    * con el mismo nombre que la clave primaria de la tabla Empleado y que esta columna será utilizada para establecer
    * la relación entre las dos entidades.
    */
    @OneToOne(mappedBy = "cuentaBancaria")
    @PrimaryKeyJoinColumn
    private Empleado empleado;
}
