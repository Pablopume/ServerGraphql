package com.example.servergraphql.domain.servicios;

import com.example.servergraphql.data.modelo.TiendaEntity;
import com.example.servergraphql.data.modelo.graphql.TiendaInput;
import com.example.servergraphql.data.modelo.graphql.UpdateTiendaInput;
import com.example.servergraphql.data.modelo.mappers.TiendaEntityMapper;
import com.example.servergraphql.data.repositories.TiendaRepository;
import com.example.servergraphql.domain.modelo.Tienda;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiendaService {
    private final TiendaRepository tiendaRepository;
    private final TiendaEntityMapper tiendaMapper;

    public List<Tienda> getTiendas() {

        return tiendaRepository.findAll().stream().map(tiendaMapper::toTienda).toList();
    }

    public Tienda addTienda(TiendaInput tiendaInput) {
        TiendaEntity tienda= tiendaRepository.save(tiendaMapper.toTiendaEntity(tiendaInput));
    return tiendaMapper.toTienda(tienda);

    }
    public boolean deleteTienda(Long id) {
        tiendaRepository.deleteById(id);
        return true;
    }

    public Tienda updateTienda(UpdateTiendaInput tiendaInput) {
        TiendaEntity tienda= tiendaRepository.save(tiendaMapper.toTiendaEntity(tiendaInput));
        return tiendaMapper.toTienda(tienda);
    }
}