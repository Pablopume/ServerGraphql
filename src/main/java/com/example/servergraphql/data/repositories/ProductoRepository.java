package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.ProductoEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ListCrudRepository<ProductoEntity, Long> {
}
