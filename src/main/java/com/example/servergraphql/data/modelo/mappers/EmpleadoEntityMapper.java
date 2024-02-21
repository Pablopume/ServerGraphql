package com.example.servergraphql.data.modelo.mappers;

import com.example.servergraphql.data.modelo.EmpleadoEntity;
import com.example.servergraphql.data.modelo.graphql.EmpleadoInput;
import com.example.servergraphql.domain.modelo.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoEntityMapper {
    Empleado toEmpleado(EmpleadoEntity empleadoEntity);

    EmpleadoEntity toEmpleadoEntity(Empleado empleado);
    EmpleadoEntity toEmpleadoEntity(EmpleadoInput empleado);
}
