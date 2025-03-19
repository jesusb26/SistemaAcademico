public class Evaluacion {
    private String nombre;
    private Curso curso;

    public Evaluacion(String nombre, Curso curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Evaluación: " + nombre + ", " + curso;
    }
}