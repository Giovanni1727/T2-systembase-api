package com.labajos.systembase_api.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.labajos.systembase_api.modelos.Equipo;

public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {
    // Para listar solo los equipos de un Cliente
    List<Equipo> findByEmpresaId(Long empresaId);
    
    // Para buscar y eliminar usando la SERIE exacta
    Optional<Equipo> findBySerie(String serie);
}