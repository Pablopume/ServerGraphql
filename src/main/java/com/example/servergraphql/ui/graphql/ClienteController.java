package com.example.servergraphql.ui.graphql;

import com.example.servergraphql.domain.modelo.Cliente;
import com.example.servergraphql.domain.modelo.Empleado;
import com.example.servergraphql.domain.servicios.ClienteService;
import com.example.servergraphql.domain.servicios.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @QueryMapping
    @Secured("ROLE_ADMIN")
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @MutationMapping
    @Secured("ROLE_ADMIN")
    public boolean deleteCliente(@Argument Long id) {
        return clienteService.deleteCliente(id);
    }
}
