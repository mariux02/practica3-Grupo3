package com.practica.demo.controller;

import com.practica.demo.domain.Arbol;
import com.practica.demo.service.ArbolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/categorias")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String mostrarListadoArboles(Model model) {
        log.info("Mostrando listado de árboles.");
        
        final List<Arbol> arboles = arbolService.getArboles(true);
        model.addAttribute("arboles", arboles);

        log.info("Número de árboles en el listado: {}", arboles.size());
        return "categorias/listado";
    }
     @GetMapping("/sumar")
    public String mostrarFormularioSuma() {
        return "/categoria/sumaFormulario";
    }

    @PostMapping("/sumar")
    public String sumarNumeros(@RequestParam int numero1, @RequestParam int numero2, Model model) {
        int resultado = numero1 + numero2;
        model.addAttribute("numero1", numero1);
        model.addAttribute("numero2", numero2);
        model.addAttribute("resultado", resultado);
        return "/categoria/resultadoSuma";
    }
}