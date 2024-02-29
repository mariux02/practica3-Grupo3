package com.practica.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="categorias")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_arbol")
    private Long id_arbol;
    
    @Column(name="nombre_comun")
    private String nombre_comun;
    
    @Column(name="tipo_flor")
    private String tipo_flor;
    
    @Column(name="dureza_madera")
    private String dureza_madera;
    
    @Column(name="otro_campo_numerico")
    private Integer otro_campo_numerico;
    
    @Column(name="otro_campo_texto")
    private String otro_campo_texto;
    
    @Column(name="ruta_imagen")
    private String ruta_imagen;
    
    @Column(name="activo")
    private boolean activo;
   
    public Arbol() {
    }

    public Arbol(String nombre_comun, String tipo_flor, String dureza_madera, Integer otro_campo_numerico, String otro_campo_texto, String ruta_imagen,boolean activo) {
        this.nombre_comun = nombre_comun;
        this.tipo_flor = tipo_flor;
        this.dureza_madera = dureza_madera;
        this.otro_campo_numerico = otro_campo_numerico;
        this.otro_campo_texto = otro_campo_texto;
        this.ruta_imagen = ruta_imagen;
    }
}