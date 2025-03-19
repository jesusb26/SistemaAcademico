public class Equipo extends RecursoEducativo {
    private String tipo; // "computadora", "proyector", etc.
    private String numeroSerie;

    public Equipo(String id, String nombre, String tipo, String numeroSerie) {
        super(id, nombre);
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }
}