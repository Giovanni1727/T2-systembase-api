package com.labajos.systembase_api.servicios;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.labajos.systembase_api.modelos.Equipo;
import com.labajos.systembase_api.repositorio.EquipoRepositorio;

@Service
public class EquipoServicio {
    private final EquipoRepositorio repositorio;

    public EquipoServicio(EquipoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Equipo> listarTodos() {
        return repositorio.findAll();
    }

    public List<Equipo> listarPorEmpresa(Long empresaId) {
        return repositorio.findByEmpresaId(empresaId);
    }

    public Equipo guardar(Equipo equipo) {
        return repositorio.save(equipo);
    }

    // Regla cumplida: Se elimina buscando por la SERIE
    public void eliminarPorSerie(String serie) {
        Equipo equipo = repositorio.findBySerie(serie)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe un equipo con esa serie"));
        repositorio.delete(equipo);
    }
}