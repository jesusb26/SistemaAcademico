public class EventoAcademico {
    private String tipo; // "examen", "tarea", "reunión", "evento"
    private String fechaInicio;
    private String fechaFin;
    private int hora;
    private String descripcion;
    private Curso cursoRelacionado;

    public EventoAcademico(String tipo, String fechaInicio, String fechaFin, int hora, String descripcion, Curso cursoRelacionado) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.hora = hora;
        this.descripcion = descripcion;
        this.cursoRelacionado = cursoRelacionado;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public int getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Curso getCursoRelacionado() {
        return cursoRelacionado;
    }
}