public class Tarea {
    private String nombre;
    private Curso curso;
    private String fechaLimite;

    public Tarea(String nombre, Curso curso, String fechaLimite) {
        this.nombre = nombre;
        this.curso = curso;
        this.fechaLimite = fechaLimite;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }
}