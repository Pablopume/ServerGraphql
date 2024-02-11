package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.EmpleadoEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ListCrudRepository<EmpleadoEntity, Long> {
}
