package com.example.servergraphql.data.modelo;


import jakarta.persistence.*;

@Entity
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    String nombre;
    @Column
    String apellido;
    @Column
    String cargo;
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    TiendaEntity tienda;

}
