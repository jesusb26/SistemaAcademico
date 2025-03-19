public abstract class RecursoEducativo {
    private String id;
    private String nombre;
    private String estado; // "disponible", "prestado", "en_mantenimiento"

    public RecursoEducativo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estado = "disponible";
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}