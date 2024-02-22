package com.example.servergraphql.ui.graphql;

import com.example.servergraphql.data.modelo.graphql.EmpleadoInput;
import com.example.servergraphql.domain.modelo.Empleado;
import com.example.servergraphql.domain.modelo.Producto;
import com.example.servergraphql.domain.servicios.EmpleadoService;
import com.example.servergraphql.domain.servicios.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;
    @QueryMapping
    @Secured("ROLE_ADMIN")
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

}
