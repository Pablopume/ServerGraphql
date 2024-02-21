package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.VentaEntity;
import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.data.modelo.mappers.VentaEntityMapper;
import com.example.servergraphql.data.repositories.VentaRepository;
import com.example.servergraphql.domain.modelo.Venta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;
    private final VentaEntityMapper ventaMapper;
    private final UpdateMapperService updateMapperService;

    public List<Venta> getVentas() {
        return ventaRepository.findAll().stream().map(ventaMapper::toVenta).toList();
    }

    public Boolean upddateVenta(UpdateVentaInput ventaInput) {
        ventaRepository.save(updateMapperService.toVentaEntity(ventaInput));
        return true;
    }
}
