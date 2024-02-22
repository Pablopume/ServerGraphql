package com.example.servergraphql.data.modelo.mappers;

import com.example.servergraphql.data.modelo.ClienteEntity;
import com.example.servergraphql.data.modelo.ProductoEntity;
import com.example.servergraphql.domain.modelo.Cliente;
import com.example.servergraphql.domain.modelo.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoEntityMapper {

Producto toProducto(ProductoEntity productoEntity);

}
