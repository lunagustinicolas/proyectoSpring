package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServicetest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_idExistente_retornaProvinciaConIdIngresado() {

        Provincia provincia = provinciaService.buscarPorId(3L);

        assertNotNull(provincia);

        assertEquals(3L, provincia.getId());
    }

    @Test
    public void buscarPorId_idInexistente_retornaNull() {

        Provincia provincia = provinciaService.buscarPorId(2L);

        assertNull(provincia);
    }
}
