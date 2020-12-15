package com.dosideas.repository;

import com.dosideas.domain.Provincia;

public interface ProvinciaRepository {

    Provincia findById(Long id);
}
