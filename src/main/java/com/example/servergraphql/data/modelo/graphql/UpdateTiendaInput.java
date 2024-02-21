package com.example.servergraphql.data.modelo.graphql;

public record UpdateTiendaInput(Long id, String nombre, String ubicacion,Long empleadoId, Long clienteId) {
}
