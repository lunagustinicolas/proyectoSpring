package com.dosideas.controller;

import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @RequestMapping("/provincias")
    public String provincias(Model model) {
        List<Provincia> provincias = provinciaService.buscarTodos();
        model.addAttribute("provincias", provincias);
        return "provincia";
    }

    @RequestMapping("/provinciasBuscadasContiene")
    public String provinciasBuscadasContiene(@RequestParam String busqueda, Model model) {
        List<Provincia> provinciasBuscadasContiene = provinciaService.buscarPorNombreDeProvinciaContiene(busqueda);
        System.out.println(busqueda);
        System.out.println(provinciasBuscadasContiene);
        model.addAttribute("provinciasBuscadasContiene", provinciasBuscadasContiene);
        List<Provincia> provincias = provinciaService.buscarTodos();
        model.addAttribute("provincias", provincias);
        return "provincia";
    }
}
