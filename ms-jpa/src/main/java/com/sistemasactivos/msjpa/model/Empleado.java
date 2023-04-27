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


    /*
    * Relacion OneToOne "tradicional"
    *
    * En este caso, la entidad Empleado tiene una referencia a la entidad Domicilio a través de la anotación @OneToOne
    * y la anotación @JoinColumn indica que la clave foránea se almacena en la columna "domicilio_id" de la tabla
    * Empleado.
    */
    @OneToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;


    /*
    * Relacion OneToOne "compartiendo id"
    *
    * En este caso, la entidad Empleado tiene una referencia a la entidad CuentaBancaria a través de la anotación
    * @OneToOne y la anotación @MapsId indica que la clave primaria de la entidad Empleado también se utiliza como
    * clave primaria para la entidad CuentaBancaria. La anotación @JoinColumn indica que la clave foránea se almacena en
    * la columna "cuenta_bancaria_id" de la tabla Empleado.
    */
    @OneToOne
    @MapsId
    @JoinColumn(name="cuenta_bancaria_id")
    private CuentaBancaria cuentaBancaria;


    /*
    * Relacion OneToOne "creando tabla intermedia"
    *
    * En este caso, la entidad Empleado tiene una referencia a la entidad Contrato a través de la anotación @OneToOne y
    * la anotación @JoinTable indica que la relación se mapea a través de una tabla intermedia llamada "empleado_contrato".
    * La anotación @JoinColumn especifica la columna en la tabla intermedia que se utiliza para la clave foránea de la
    * entidad Empleado. La anotación @inverseJoinColumns especifica la columna en la tabla intermedia que se utiliza para
    * la clave foránea de la entidad Contrato.
    */
    @OneToOne
    @JoinTable(name = "empleado_contrato",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "contrato_id"))
    private Contrato contrato;
}
