package com.example.servergraphql.data.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column
    String nombre;
    @Column
    String email;
    //cascade remove para que al borrar un cliente se borren todas sus ventas
    @Column
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    List<VentaEntity> ventas;

}
