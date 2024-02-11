package com.example.servergraphql.data.modelo.mappers;

import com.example.servergraphql.data.modelo.TiendaEntity;
import com.example.servergraphql.data.modelo.graphql.TiendaInput;
import com.example.servergraphql.data.modelo.graphql.UpdateTiendaInput;
import com.example.servergraphql.domain.modelo.Tienda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TiendaEntityMapper {

    Tienda toTienda(TiendaEntity tiendaEntity);
    TiendaEntity toTiendaEntity(Tienda tienda);

    Tienda toTienda(TiendaInput tiendaInput);
    TiendaEntity toTiendaEntity(TiendaInput tiendaInput);
    Tienda toTienda(UpdateTiendaInput updateTiendaInput);
    TiendaEntity toTiendaEntity(UpdateTiendaInput updateTiendaInput);
}
