public class EspacioAcademico {
    private String nombre;
    private int capacidad;
    private String tipo; // "aula", "laboratorio", "virtual"
    private String proposito;
    private String estado; // "disponible", "ocupado", "mantenimiento"

    public EspacioAcademico(String nombre, int capacidad, String tipo, String proposito) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.proposito = proposito;
        this.estado = "disponible"; // Por defecto, el espacio está disponible
    }

    // Método para verificar la disponibilidad del espacio
    public boolean verificarDisponibilidad() {
        return "disponible".equals(estado);
    }

    // Método para actualizar el estado del espacio
    public void actualizarEstado(String estado) {
        this.estado = estado;
        System.out.println("Estado del espacio " + nombre + " actualizado a: " + estado);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getProposito() {
        return proposito;
    }

    public String getEstado() {
        return estado;
    }
}