package com.labajos.systembase_api.consola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.labajos.systembase_api.modelos.Empresa;
import com.labajos.systembase_api.modelos.Usuario;
import com.labajos.systembase_api.repositorio.EmpresaRepositorio;
import com.labajos.systembase_api.repositorio.UsuarioRepositorio;

@Component
public class DatosIniciales implements CommandLineRunner { 

    private final EmpresaRepositorio empresaRepo;
    private final UsuarioRepositorio usuarioRepo;

    public DatosIniciales(EmpresaRepositorio empresaRepo, UsuarioRepositorio usuarioRepo) {
        this.empresaRepo = empresaRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Si no hay empresas, creamos los datos por defecto
        if (empresaRepo.count() == 0) {
            Empresa systemBase = new Empresa(null, "SystemBase", "11111111111");
            systemBase = empresaRepo.save(systemBase);

            // Creamos el Administrador maestro asignado a SystemBase
            Usuario admin = new Usuario(null, "admin", "admin", "ADMIN", systemBase);
            usuarioRepo.save(admin);
            
            System.out.println("=== DATOS INICIALES CARGADOS ===");
            System.out.println("Empresa: SystemBase (ID: " + systemBase.getId() + ")");
            System.out.println("Usuario Admin: admin / admin");
            System.out.println("===========================");
        }
    }
}