package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

public interface ProvinciaService {

    Provincia buscarPorId(long id);
    
    List<Provincia> buscarTodos();
    
    Provincia buscarPorNombre(String nombre);
    
    List<Provincia> buscarPorNombreDeProvinciaContiene(String contenido);
    
    List<Provincia> buscarPorNombreDePais(String nombre);

}
