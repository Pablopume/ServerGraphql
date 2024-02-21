package com.example.servergraphql.data.modelo.mappers;

import com.example.servergraphql.data.modelo.VentaEntity;
import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.domain.modelo.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaEntityMapper {
 VentaEntity toEntity(UpdateVentaInput ventaInput);
 Venta toVenta(VentaEntity ventaEntity);
}
