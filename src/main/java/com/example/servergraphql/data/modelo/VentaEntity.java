package com.example.servergraphql.data.modelo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
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
