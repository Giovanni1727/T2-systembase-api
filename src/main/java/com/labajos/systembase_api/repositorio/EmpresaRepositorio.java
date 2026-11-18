package com.labajos.systembase_api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.labajos.systembase_api.modelos.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}