package com.example.servergraphql.data.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    LocalDate fecha;
    @Column
    double total;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    EmpleadoEntity empleado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    ClienteEntity cliente;

}
