package com.example.servergraphql.domain.modelo;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record Venta(Long id, LocalDate fecha, double total, Long clienteId, Long empleadoId) {

}
