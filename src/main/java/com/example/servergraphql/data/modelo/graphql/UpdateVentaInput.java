package com.example.servergraphql.data.modelo.graphql;

import java.time.LocalDate;

public record UpdateVentaInput(Long id, LocalDate fecha, double total, Long clienteId, Long empleadoId) {

}
