package com.example.servergraphql.data.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    String nombre;
    @Column
    double precio;
    @Column
    int stock;
    @ManyToMany
    List<TiendaEntity> tiendas;

}
