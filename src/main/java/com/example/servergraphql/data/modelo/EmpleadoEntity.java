package com.example.servergraphql.data.modelo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
    @Column(name= "tienda_id", insertable = false, updatable = false)
    Long tiendaId;
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    TiendaEntity tienda;

}
