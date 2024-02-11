package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.VentaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends ListCrudRepository<VentaEntity, Long> {
}
