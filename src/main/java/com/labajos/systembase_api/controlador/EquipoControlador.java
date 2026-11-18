package com.labajos.systembase_api.controlador;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.labajos.systembase_api.modelos.Equipo;
import com.labajos.systembase_api.servicios.EquipoServicio;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipoControlador {

    private final EquipoServicio servicio;

    public EquipoControlador(EquipoServicio servicio) {
        this.servicio = servicio;
    }

    // ADMIN: Ve todos los equipos
    @GetMapping
    public List<Equipo> listarTodos() {
        return servicio.listarTodos();
    }

    // CLIENTE: Ve solo los equipos de su empresa
    @GetMapping("/empresa/{empresaId}")
    public List<Equipo> listarPorEmpresa(@PathVariable Long empresaId) {
        return servicio.listarPorEmpresa(empresaId);
    }

    // Crear un nuevo equipo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo registrar(@RequestBody Equipo equipo) {
        return servicio.guardar(equipo);
    }

    // Editar un equipo existente
    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipoActualizado) {
        equipoActualizado.setId(id); // Aseguramos que se actualice el correcto
        return servicio.guardar(equipoActualizado);
    }

    // Eliminar por SERIE (Tal como pediste)
    @DeleteMapping("/serie/{serie}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPorSerie(@PathVariable String serie) {
        servicio.eliminarPorSerie(serie);
    }
}