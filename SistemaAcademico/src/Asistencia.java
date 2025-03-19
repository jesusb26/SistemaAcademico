public class Asistencia {
    private Estudiante estudiante;
    private Curso curso;
    private String fecha;

    public Asistencia(Estudiante estudiante, Curso curso, String fecha) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = fecha;
    }

    // Getters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Curso: " + curso.getNombre();
    }
}