package com.example.servergraphql.data.repositories;

import com.example.servergraphql.data.modelo.ClienteEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ListCrudRepository<ClienteEntity, Long> {


}
