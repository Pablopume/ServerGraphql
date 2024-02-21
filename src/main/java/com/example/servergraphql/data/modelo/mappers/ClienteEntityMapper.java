package com.example.servergraphql.data.modelo.mappers;

import com.example.servergraphql.data.modelo.ClienteEntity;
import com.example.servergraphql.domain.modelo.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    Cliente toCliente(ClienteEntity clienteEntity);

}
