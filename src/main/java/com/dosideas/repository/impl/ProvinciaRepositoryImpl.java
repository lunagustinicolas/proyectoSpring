package com.dosideas.repository.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProvinciaRepositoryImpl implements ProvinciaRepository {

    @Override
    public Provincia findById(Long id) {
        if (id != 3L) {
            return null;
        }
        Provincia provincia = new Provincia();

        provincia.setId(id);

        return provincia;
    }

}
