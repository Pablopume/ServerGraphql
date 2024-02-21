package com.example.servergraphql.ui.graphql;

import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.domain.modelo.Tienda;
import com.example.servergraphql.domain.modelo.Venta;
import com.example.servergraphql.domain.servicios.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VentaController {
    private final VentaService ventaService;
    @QueryMapping
    @Secured("ROLE_ADMIN")
    public List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    @MutationMapping
    @Secured("ROLE_ADMIN")
    public boolean updateVenta(@Argument UpdateVentaInput updateVentaInput) {
        return ventaService.upddateVenta(updateVentaInput);
    }
}
