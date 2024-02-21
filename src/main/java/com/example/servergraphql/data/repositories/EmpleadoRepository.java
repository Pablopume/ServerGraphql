package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.EmpleadoEntity;
import com.example.servergraphql.data.modelo.TiendaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends ListCrudRepository<EmpleadoEntity, Long> {
    List<EmpleadoEntity> getEmpleadoByTienda(TiendaEntity tiendaEntity);
}
