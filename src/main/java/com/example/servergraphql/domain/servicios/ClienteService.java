package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.mappers.ClienteEntityMapper;
import com.example.servergraphql.data.repositories.ClienteRepository;
import com.example.servergraphql.domain.modelo.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper mapper;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll().stream().map(mapper::toCliente).toList();
    }

    public boolean deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return true;
    }
}
