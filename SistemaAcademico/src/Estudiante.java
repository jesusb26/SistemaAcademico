import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private List<Asistencia> asistencias; // Lista de asistencias
    private List<Calificacion> calificaciones; // Lista de calificaciones

    public Estudiante(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
        this.asistencias = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    // Método para registrar asistencia
    public void registrarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    // Método para registrar calificación
    public void registrarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    // Getters
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }
}