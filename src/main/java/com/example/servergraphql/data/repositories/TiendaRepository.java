package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.TiendaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TiendaRepository extends ListCrudRepository<TiendaEntity, Long> {

}
