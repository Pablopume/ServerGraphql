package com.example.servergraphql.data.modelo;

import com.example.servergraphql.domain.modelo.Cliente;
import com.example.servergraphql.domain.modelo.Empleado;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    Date fecha;
    @Column
    double total;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    EmpleadoEntity empleado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    ClienteEntity cliente;
}
