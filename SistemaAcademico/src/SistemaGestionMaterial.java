import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaGestionMaterial {
    private List<RecursoEducativo> recursos; 
    private List<String> prestamos; 
    private List<String> mantenimientos; 

    public SistemaGestionMaterial(List<RecursoEducativo> recursos) {
        this.recursos = recursos;
        this.prestamos = new ArrayList<>();
        this.mantenimientos = new ArrayList<>();
    }

    public void realizarPrestamo(String idRecurso, Usuario usuario, Date fechaPrestamo) {
       // logica para realizar prestamos
    }

    public void registrarDevolucion(String idRecurso, Usuario usuario, Date fechaDevolucion, String estadoRecurso) {
       // Logica para registrar la devolucion
    }

    public void registrarMantenimiento(String idRecurso, Date fechaInicio, String descripcion) {
      // Logica para registrar el mantenimiento
    }

    public void finalizarMantenimiento(String idRecurso, Date fechaFin) {
        //finalizar mantenimiento
    }

    // Método para buscar un recurso por ID
    private RecursoEducativo buscarRecurso(String idRecurso) {
        for (RecursoEducativo recurso : recursos) {
            if (recurso.getId().equals(idRecurso)) {
                return recurso;
            }
        }
        return null; // Si no se encuentra el recurso
    }

    // Método para listar todos los recursos
    public void listarRecursos() {
       
    }

    // Método para listar todos los préstamos
    public void listarPrestamos() {
       
    }

    public void verPrestamosDeUsuario(Usuario usuario) {

    }

    // Método para listar todos los mantenimientos
    public void listarMantenimientos() {
        
    }
}