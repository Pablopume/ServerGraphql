package com.example.servergraphql.data.modelo;

import jakarta.persistence.*;

@Entity

public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    String nombre;
    @Column
    String email;

}
