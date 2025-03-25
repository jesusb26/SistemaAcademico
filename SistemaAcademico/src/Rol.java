import java.util.List;

public class Rol {
    private String nombre; // "administrador", "docente", "estudiante", "personal_administrativo"
    private List<String> permisos; // Lista de permisos

    public Rol(String nombre, List<String> permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }

    // Método para verificar si el rol tiene un permiso específico
    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }
}