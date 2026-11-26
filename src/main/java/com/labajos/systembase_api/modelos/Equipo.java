package com.labajos.systembase_api.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 30)
    private String serie;

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @Column(length = 30)
    private String procesador;

    @Column(length = 30)
    private String ram;

    @Column(length = 30)
    private String disco;

    @Column(length = 30)
    private String tamano;

    @Column(length = 30)
    private String compatibilidad;

    @Column(length = 30)
    private String interfaz;

    private LocalDate fechaInicioAlquiler;
    private LocalDate fechaFinAlquiler;
    private Integer mesesAlquiler;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    public String getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(String interfaz) {
        this.interfaz = interfaz;
    }

    public LocalDate getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public LocalDate getFechaFinAlquiler() {
        return fechaFinAlquiler;
    }

    public void setFechaFinAlquiler(LocalDate fechaFinAlquiler) {
        this.fechaFinAlquiler = fechaFinAlquiler;
    }

    public Integer getMesesAlquiler() {
        return mesesAlquiler;
    }

    public void setMesesAlquiler(Integer mesesAlquiler) {
        this.mesesAlquiler = mesesAlquiler;
    }
}