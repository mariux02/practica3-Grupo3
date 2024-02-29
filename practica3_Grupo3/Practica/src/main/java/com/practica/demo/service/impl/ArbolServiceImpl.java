/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.demo.service.impl;

import com.practica.demo.dao.ArbolDao;
import com.practica.demo.domain.Arbol;
import com.practica.demo.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(boolean activos) {
        List<Arbol> lista = arbolDao.findAll();

        if (activos) {
            lista = lista.stream()
                    .filter(Arbol::isActivo)
                    .collect(Collectors.toList());
        }

        return lista;
    }
}