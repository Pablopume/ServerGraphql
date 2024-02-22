package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.mappers.ClienteEntityMapper;
import com.example.servergraphql.data.repositories.ClienteRepository;
import com.example.servergraphql.domain.modelo.Cliente;
import com.example.servergraphql.domain.modelo.exceptions.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper mapper;

    public List<Cliente> getClientes() {
        List<Cliente> clientes = clienteRepository.findAll().stream().map(mapper::toCliente).toList();
        if (clientes.isEmpty()) {
            throw new NoEncontradoException("No hay clientes");
        } else {
            return clientes;
        }
    }

    public boolean deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return true;
    }
}
