package com.example.servergraphql.data.modelo;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class TiendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "ubicacion")
    String ubicacion;

    @OneToMany(mappedBy = "tienda")
    List<EmpleadoEntity> empleados;
    @ManyToMany(mappedBy = "tiendas")
    List<ProductoEntity> productos;


}

