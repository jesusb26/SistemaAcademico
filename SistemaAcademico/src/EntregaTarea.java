public class EntregaTarea {
    private Estudiante estudiante;
    private Tarea tarea;
    private String fechaEntrega;

    public EntregaTarea(Estudiante estudiante, Tarea tarea, String fechaEntrega) {
        this.estudiante = estudiante;
        this.tarea = tarea;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }
}