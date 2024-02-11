package com.example.servergraphql.data.modelo;

import com.example.servergraphql.domain.modelo.Tienda;
import jakarta.persistence.*;

import java.util.List;

@Entity
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
