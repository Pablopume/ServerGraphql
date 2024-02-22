package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.ClienteEntity;
import com.example.servergraphql.data.modelo.EmpleadoEntity;
import com.example.servergraphql.data.modelo.TiendaEntity;
import com.example.servergraphql.data.modelo.VentaEntity;
import com.example.servergraphql.data.modelo.graphql.EmpleadoInput;
import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.data.repositories.ClienteRepository;
import com.example.servergraphql.data.repositories.EmpleadoRepository;
import com.example.servergraphql.data.repositories.TiendaRepository;
import com.example.servergraphql.data.repositories.VentaRepository;
import com.example.servergraphql.domain.modelo.Empleado;
import com.example.servergraphql.domain.modelo.Venta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperService {
    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;
    private final TiendaRepository tiendaRepository;


    public VentaEntity toVentaEntity(UpdateVentaInput updateVentaInput) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(updateVentaInput.empleadoId()).orElseThrow();
        ClienteEntity clienteEntity = clienteRepository.findById(updateVentaInput.clienteId()).orElseThrow();
        return new VentaEntity(updateVentaInput.id(), updateVentaInput.fecha(), updateVentaInput.total(),empleadoEntity,clienteEntity);

    }

    public Venta toVenta(VentaEntity ventaEntity) {

        return new Venta(ventaEntity.getId(), ventaEntity.getFecha(), ventaEntity.getTotal(), ventaEntity.getCliente().getId(), ventaEntity.getEmpleado().getId());
    }

    public EmpleadoEntity toEmpleadoEntity(EmpleadoInput empleadoInput) {
        TiendaEntity tiendaEntity = tiendaRepository.findById(empleadoInput.tiendaId()).orElseThrow();
        EmpleadoEntity empleadoEntity = new EmpleadoEntity(null, empleadoInput.nombre(), empleadoInput.apellido(), empleadoInput.cargo(), null,tiendaEntity);
        return empleadoRepository.save(empleadoEntity);
    }
}
