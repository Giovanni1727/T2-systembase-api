package com.labajos.systembase_api.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.labajos.systembase_api.modelos.Usuario;
import com.labajos.systembase_api.repositorio.UsuarioRepositorio;

@Service
public class AuthServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    public AuthServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Método para autenticar en el Login
    public Usuario autenticar(String correo, String password) {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        throw new RuntimeException("Credenciales incorrectas");
    }

    // Método para registrar un nuevo usuario (Cliente)
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // NUEVO: Método para listar todos los usuarios en la vista de Configuración
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}