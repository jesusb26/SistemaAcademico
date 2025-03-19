import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Crear roles y permisos
        List<String> permisosAdmin = Arrays.asList("gestionar_usuarios", "gestionar_espacios", "generar_reportes");
        Rol rolAdmin = new Rol("administrador", permisosAdmin);

        List<String> permisosDocente = Arrays.asList("gestionar_clases", "calificar_tareas");
        Rol rolDocente = new Rol("docente", permisosDocente);

        // Crear usuarios
        Usuario admin = new Usuario("Carlos", "carlos@example.com", "123456789");
        admin.definirContraseña("admin123");
        admin.asignarRol(rolAdmin);

        Usuario docente = new Usuario("Ana", "ana@example.com", "987654321");
        docente.definirContraseña("docente123");
        docente.asignarRol(rolDocente);

        // Registrar usuarios en el sistema de seguridad
        SistemaSeguridad sistemaSeguridad = new SistemaSeguridad();
        sistemaSeguridad.registrarUsuario(admin);
        sistemaSeguridad.registrarUsuario(docente);

        // Iniciar sesión
        sistemaSeguridad.iniciarSesion("carlos@example.com", "admin123"); // Éxito
        sistemaSeguridad.iniciarSesion("ana@example.com", "docente123"); // Éxito

        // Verificar permisos
        sistemaSeguridad.verificarAcceso(admin, "gestionar_usuarios"); // Acceso concedido
        sistemaSeguridad.verificarAcceso(docente, "gestionar_usuarios"); // Acceso denegado

        // Recuperar contraseña
        sistemaSeguridad.recuperarContrasena("carlos@example.com");

        // Validar identidad (simulado)
        sistemaSeguridad.validarIdentidad("carlos@example.com", "token_simulado");
    }
}