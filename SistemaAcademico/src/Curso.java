import java.util.List;

public class Curso {
    private String nombre;
    private List<Estudiante> estudiantes;

    public Curso(String nombre, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}