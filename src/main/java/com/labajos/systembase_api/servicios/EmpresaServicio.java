package com.labajos.systembase_api.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.labajos.systembase_api.modelos.Empresa;
import com.labajos.systembase_api.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicio {
    private final EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Empresa> listarTodas() {
        return repositorio.findAll();
    }

    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }
}