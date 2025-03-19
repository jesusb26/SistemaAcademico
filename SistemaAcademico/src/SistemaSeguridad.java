import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaSeguridad {
    private Map<String, Usuario> usuariosRegistrados; // Mapa de usuarios registrados (email -> Usuario)

    public SistemaSeguridad() {
        this.usuariosRegistrados = new HashMap<>();
    }

    // Método para registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.put(usuario.getEmail(), usuario);
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String email, String contrasena) {
        return false;
    }

    // Método para recuperar contraseña
    public void recuperarContrasena(String email) {
        
    }

    // Método para validar identidad
    public boolean validarIdentidad(String email, String token) {
        return false;
    }

    // Método para verificar si un usuario tiene un permiso específico
    public boolean tienePermiso(Usuario usuario, String permiso) {
        if (usuario.getRol() != null) {
            return usuario.getRol().tienePermiso(permiso);
        }
        return false;
    }

    // Método para verificar el acceso a una funcionalidad
    public void verificarAcceso(Usuario usuario, String funcionalidad) {
       
    }
}