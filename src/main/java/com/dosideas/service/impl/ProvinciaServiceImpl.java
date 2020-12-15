package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public Provincia buscarPorId(long id) {
        return provinciaRepository.findById(id);
    }

}
