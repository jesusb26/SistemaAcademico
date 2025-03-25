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
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String email, String contrasena) {
        Usuario usuario = usuariosRegistrados.get(email);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso: " + usuario.getNombre());
            return true;
        } else {
            System.out.println("Email o contraseña incorrectos.");
            return false;
        }
    }

    // Método para recuperar contraseña
    public void recuperarContrasena(String email) {
        Usuario usuario = usuariosRegistrados.get(email);
        if (usuario != null) {
            System.out.println("Se ha enviado un enlace de recuperación a: " + usuario.getEmail());
        } else {
            System.out.println("El email no está registrado.");
        }
    }

    // Método para validar identidad (simulado)
    public boolean validarIdentidad(String email, String token) {
        Usuario usuario = usuariosRegistrados.get(email);
        if (usuario != null && usuario.validarTokenSeguridad()) {
            System.out.println("Identidad validada: " + usuario.getNombre());
            return true;
        } else {
            System.out.println("Token inválido o expirado.");
            return false;
        }
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
        if (tienePermiso(usuario, funcionalidad)) {
            System.out.println("Acceso concedido a " + usuario.getNombre() + " para: " + funcionalidad);
        } else {
            System.out.println("Acceso denegado a " + usuario.getNombre() + " para: " + funcionalidad);
        }
    }
}