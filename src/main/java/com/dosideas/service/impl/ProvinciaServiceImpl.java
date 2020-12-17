package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Provincia buscarPorId(long id) {
        return provinciaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<Provincia> buscarTodos() {
        return provinciaRepository
                .findAll();
    }

    @Override
    public Provincia buscarPorNombre(String nombre) {
        return provinciaRepository
                .findByNombreIgnoreCase(nombre);
    }

    @Override
    public List<Provincia> buscarPorNombreDeProvinciaContiene(String contenido) {
        return provinciaRepository
                .findByNombreContainingIgnoreCase(contenido);
    }

    @Override
    public List<Provincia> buscarPorNombreDePais(String nombre) {
        return provinciaRepository
                .findByPaisNombreIgnoreCase(nombre);
    }
}
