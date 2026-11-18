package com.labajos.systembase_api.seguridad;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.stereotype.Component;
import com.labajos.systembase_api.modelos.Usuario;

@Component
public class SesionFalsa {
    
    // Genera un token: "idUsuario:ROL:idEmpresa" en Base64
    public String crearToken(Usuario usuario) {
        String texto = usuario.getId() + ":" + usuario.getRol() + ":" + usuario.getEmpresa().getId();
        return Base64.getEncoder().encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }
}