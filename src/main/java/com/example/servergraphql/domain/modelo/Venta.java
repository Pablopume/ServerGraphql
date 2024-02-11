package com.example.servergraphql.domain.modelo;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

public record Venta(Long id, Date fecha, double total, Empleado empleado, Cliente cliente) {

}
