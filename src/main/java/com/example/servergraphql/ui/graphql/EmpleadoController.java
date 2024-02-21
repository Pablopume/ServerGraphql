package com.example.servergraphql.ui.graphql;

import com.example.servergraphql.domain.modelo.Empleado;
import com.example.servergraphql.domain.servicios.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;
    @QueryMapping
    @Secured("ROLE_ADMIN")
    public List<Empleado> getEmpleadosByIdTienda(@Argument Long id) {
        return empleadoService.getEmpleadosByTienda(id);
    }
}
