package com.labajos.systembase_api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 150)
    private String nombre;
    
    @Column(nullable = false, length = 11)
    private String ruc;

    public Empresa() {}

    public Empresa(Long id, String nombre, String ruc) {
        this.id = id;
        this.nombre = nombre;
        this.ruc = ruc;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }
}