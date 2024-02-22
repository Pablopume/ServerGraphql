package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.data.repositories.VentaRepository;
import com.example.servergraphql.domain.modelo.Venta;
import com.example.servergraphql.domain.modelo.exceptions.NoEncontradoException;
import com.example.servergraphql.domain.modelo.exceptions.PrecioMuyAltoExpcetion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;

    private final MapperService mapperService;

    public List<Venta> getVentas() {

        List<Venta>ventas= ventaRepository.findAll().stream().map(mapperService::toVenta).toList();
        if (ventas.isEmpty()) {
            throw new NoEncontradoException("No hay ventas");
        } else {
            return ventas;
        }
    }

    public Boolean upddateVenta(UpdateVentaInput ventaInput) {
        if (ventaInput.total()>1000000){
            throw new PrecioMuyAltoExpcetion("No se puede realizar la venta, el precio es muy alto");
        }else {
            ventaRepository.save(mapperService.toVentaEntity(ventaInput));
            return true;
        }

    }

    public Venta getVentaById(Long id) {
        return mapperService.toVenta(ventaRepository.findById(id).orElseThrow());
    }
}
