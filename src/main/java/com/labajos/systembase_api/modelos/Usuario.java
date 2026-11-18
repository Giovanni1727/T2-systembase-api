package com.labajos.systembase_api.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 20)
    private String rol; // "ADMIN" o "CLIENTE"

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Usuario() {}

    public Usuario(Long id, String correo, String password, String rol, Empresa empresa) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.empresa = empresa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}