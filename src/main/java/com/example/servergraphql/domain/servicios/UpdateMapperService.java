package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.ClienteEntity;
import com.example.servergraphql.data.modelo.EmpleadoEntity;
import com.example.servergraphql.data.modelo.VentaEntity;
import com.example.servergraphql.data.modelo.graphql.UpdateVentaInput;
import com.example.servergraphql.data.repositories.ClienteRepository;
import com.example.servergraphql.data.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateMapperService {
    private final EmpleadoRepository empleadoRepository;
    private final ClienteRepository clienteRepository;

    public VentaEntity toVentaEntity(UpdateVentaInput updateVentaInput) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findById(updateVentaInput.empleadoId()).orElseThrow();
        ClienteEntity clienteEntity = clienteRepository.findById(updateVentaInput.clienteId()).orElseThrow();
        return new VentaEntity(updateVentaInput.id(), updateVentaInput.fecha(), updateVentaInput.total(),empleadoEntity,clienteEntity);

    }
}
