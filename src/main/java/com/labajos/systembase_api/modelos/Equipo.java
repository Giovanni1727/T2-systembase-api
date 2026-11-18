package com.labajos.systembase_api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Campos Comunes ---
    @Column(nullable = false, unique = true, length = 50)
    private String serie;

    @Column(nullable = false, length = 50)
    private String tipo; // Laptop, Desktop, Impresora, Escaner, Pistola

    @Column(nullable = false, length = 100)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // --- Campos Específicos (Laptops/Desktops) ---
    @Column(length = 100)
    private String procesador;
    
    @Column(length = 20)
    private String ram;
    
    @Column(length = 20)
    private String disco; // 512GB, 1TB, 2TB, 4TB
    
    @Column(length = 20)
    private String tamano; // 14'', 16'', 12''

    // --- Campos Específicos (Impresoras/Escaner/Pistola) ---
    @Column(length = 100)
    private String compatibilidad;
    
    @Column(length = 50)
    private String interfaz; // USB, RJ45, etc.

    public Equipo() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }

    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getDisco() { return disco; }
    public void setDisco(String disco) { this.disco = disco; }

    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }

    public String getCompatibilidad() { return compatibilidad; }
    public void setCompatibilidad(String compatibilidad) { this.compatibilidad = compatibilidad; }

    public String getInterfaz() { return interfaz; }
    public void setInterfaz(String interfaz) { this.interfaz = interfaz; }
}