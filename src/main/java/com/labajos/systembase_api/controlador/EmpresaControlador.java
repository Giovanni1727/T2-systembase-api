package com.labajos.systembase_api.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.labajos.systembase_api.modelos.Empresa;
import com.labajos.systembase_api.servicios.EmpresaServicio;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaControlador {

    private final EmpresaServicio servicio;

    public EmpresaControlador(EmpresaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Empresa> listarTodas() {
        return servicio.listarTodas();
    }

    @PostMapping
    public Empresa registrar(@RequestBody Empresa empresa) {
        return servicio.guardar(empresa);
    }
}