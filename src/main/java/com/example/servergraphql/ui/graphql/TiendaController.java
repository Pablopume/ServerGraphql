package com.example.servergraphql.ui.graphql;

import com.example.servergraphql.data.modelo.graphql.TiendaInput;
import com.example.servergraphql.data.modelo.graphql.UpdateTiendaInput;
import com.example.servergraphql.domain.modelo.Tienda;
import com.example.servergraphql.domain.servicios.TiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TiendaController {
    private final TiendaService tiendaService;

    @QueryMapping
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<Tienda> getTiendas() {
        return tiendaService.getTiendas();
    }

    @MutationMapping
    public Tienda addTienda(@Argument TiendaInput tiendaInput) {
        return tiendaService.addTienda(tiendaInput);
    }

    @MutationMapping
    public boolean deleteTienda(@Argument Long id) {
        return tiendaService.deleteTienda(id);
    }
    @MutationMapping
    public Tienda updateTienda(@Argument UpdateTiendaInput updateTiendaInput) {
        return tiendaService.updateTienda(updateTiendaInput);
    }
}
