package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.TiendaEntity;
import com.example.servergraphql.data.modelo.graphql.EmpleadoInput;
import com.example.servergraphql.data.modelo.mappers.EmpleadoEntityMapper;
import com.example.servergraphql.data.repositories.EmpleadoRepository;
import com.example.servergraphql.data.repositories.TiendaRepository;
import com.example.servergraphql.domain.modelo.Empleado;
import com.example.servergraphql.domain.modelo.exceptions.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoEntityMapper mapper;
    private final MapperService mapperService;
    private final TiendaRepository tiendaRepository;

    public List<Empleado> getEmpleadosByTienda(Long id) {

        TiendaEntity tiendaEntity = tiendaRepository.findById(id).orElse(null);
        List<Empleado> empleado = empleadoRepository.getEmpleadoByTienda(tiendaEntity).stream().map(mapper::toEmpleado).toList();
        if (empleado.isEmpty()) {
            throw new NoEncontradoException("No hay empleados en esa tienda");
        } else {
            return empleado;
        }
    }

    public Boolean addEmpleado(EmpleadoInput empleado) {
        mapper.toEmpleado(empleadoRepository.save(mapperService.toEmpleadoEntity(empleado)));
        return true;
    }
}