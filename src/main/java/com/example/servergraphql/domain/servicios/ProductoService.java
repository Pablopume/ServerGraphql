package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.mappers.ProductoEntityMapper;
import com.example.servergraphql.data.repositories.ProductoRepository;
import com.example.servergraphql.domain.modelo.Producto;
import com.example.servergraphql.domain.modelo.exceptions.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoEntityMapper productoEntityMapper;

    public List<Producto> getProductos() {
        List<Producto>productos= productoRepository.findAll().stream().map(productoEntityMapper::toProducto).toList();

        if (productos.isEmpty()) {
            throw new NoEncontradoException("No hay productos");
        } else {
            return productos;
        }
    }
}
