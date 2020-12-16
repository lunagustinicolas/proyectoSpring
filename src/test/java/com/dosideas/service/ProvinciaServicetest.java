package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import java.util.List;
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
        System.out.println("---------------------------------");
        System.out.println(provinciaService.getClass().getName());
        System.out.println("---------------------------------");
        Provincia provinciaBuscada = provinciaService.buscarPorId(3L);

        assertNotNull(provinciaBuscada);

        assertEquals(3L, provinciaBuscada.getId());
        assertEquals("Catamarca", provinciaBuscada.getNombre());
    }

    @Test
    public void buscarPorId_idInexistente_retornaNull() {

        Provincia provinciaBuscada = provinciaService.buscarPorId(-2L);

        assertNull(provinciaBuscada);
    }

    @Test
    public void buscarTodos_retornaTodasLasProvincias() {
        
        List<Provincia> listaDeProvincias = provinciaService.buscarTodos();

        assertEquals(20, listaDeProvincias.size());
    }

    @Test
    public void buscarPorNombre_nombreExistente_retornaProvinciaConNombreBuscado() {
        
        Provincia provinciaBuscada = provinciaService.buscarPorNombre("catamarca");

        assertEquals("Catamarca", provinciaBuscada.getNombre());
    }
    
    @Test
    public void buscarPorNombre_nombreInexistente_retornaNull() {
        
        Provincia provinciaBuscada = provinciaService.buscarPorNombre("lalala");

        assertNull(provinciaBuscada);
    }
    
    @Test 
    public void buscarPorNombreDeProvinciaContiene_nombreExistente_retornaListaDeProvinciasQueContiene() {
        
        List<Provincia> provinciasBuscadas = provinciaService.buscarPorNombreDeProvinciaContiene("sa");
        
        assertEquals(5, provinciasBuscadas.size());
    }
    
    @Test 
    public void buscarPorNombreDeProvinciaContiene_nombreInexistente_retornaListaVacia() {
        
        List<Provincia> provinciasBuscadas = provinciaService.buscarPorNombreDeProvinciaContiene("jjjjj");
        
        assertTrue(provinciasBuscadas.isEmpty());
    }
    
    @Test
    public void buscarPorNombreDePais_nombreExistente_retornaListaDeProvinciasDeEsePais(){
        
        List<Provincia> provinciasBuscadas = provinciaService.buscarPorNombreDePais("argentina");
        
        assertEquals(20, provinciasBuscadas.size());
    }
    
    @Test
    public void buscarPorNombreDePais_nombreInexistente_retornaListaVacia(){
        List<Provincia> provinciasBuscadas = provinciaService.buscarPorNombreDePais("asdasd");
        
        assertTrue(provinciasBuscadas.isEmpty());
    }
}
