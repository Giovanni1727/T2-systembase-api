package com.labajos.systembase_api.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.labajos.systembase_api.modelos.Usuario;
import com.labajos.systembase_api.seguridad.SesionFalsa;
import com.labajos.systembase_api.servicios.AuthServicio;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthControlador {

    private final AuthServicio authServicio;
    private final SesionFalsa sesionFalsa;

    public AuthControlador(AuthServicio authServicio, SesionFalsa sesionFalsa) {
        this.authServicio = authServicio;
        this.sesionFalsa = sesionFalsa;
    }

    public record LoginRequest(String correo, String password) {}
    public record LoginResponse(String token, String rol, Long empresaId) {}

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest peticion) {
        Usuario usuario = authServicio.autenticar(peticion.correo(), peticion.password());
        String token = sesionFalsa.crearToken(usuario);
        
        return new LoginResponse(token, usuario.getRol(), usuario.getEmpresa().getId());
    }

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        return authServicio.guardarUsuario(nuevoUsuario);
    }

    // NUEVO: Endpoint GET para que el Administrador vea todos los usuarios creados
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return authServicio.listarUsuarios();
    }
}