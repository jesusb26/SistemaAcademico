public class Calificacion {
    private Estudiante estudiante;
    private Evaluacion evaluacion; // Puede ser null si es una tarea
    private Tarea tarea; // Puede ser null si es una evaluación
    private double nota;

    public Calificacion(Estudiante estudiante, Evaluacion evaluacion, double nota) {
        this.estudiante = estudiante;
        this.evaluacion = evaluacion;
        this.tarea = null;
        this.nota = nota;
    }

    public Calificacion(Estudiante estudiante, Tarea tarea, double nota) {
        this.estudiante = estudiante;
        this.tarea = tarea;
        this.evaluacion = null;
        this.nota = nota;
    }

    // Getters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        if (evaluacion != null) {
            return "Evaluación: " + evaluacion.getNombre() + ", Curso: " + evaluacion.getCurso().getNombre() + ", Nota: " + nota;
        } else {
            return "Tarea: " + tarea.getNombre() + ", Curso: " + tarea.getCurso().getNombre() + ", Nota: " + nota;
        }
    }
}