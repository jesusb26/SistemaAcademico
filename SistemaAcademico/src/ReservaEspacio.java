public class ReservaEspacio {
    private EspacioAcademico espacio;
    private Usuario usuario;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String estado; // "pendiente", "confirmada", "cancelada"

    public ReservaEspacio(EspacioAcademico espacio, Usuario usuario, String fecha, String horaInicio, String horaFin) {
        this.espacio = espacio;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = "pendiente";
    }

    // Método para reportar una reserva
    public void reportarReserva() {
        espacio.actualizarEstado("ocupado");
        this.estado = "confirmada";
        System.out.println("Reserva confirmada para " + usuario.getNombre() + " en " + espacio.getNombre());
    }

    // Método para cancelar una reserva
    public void cancelarReserva() {
        espacio.actualizarEstado("disponible");
        this.estado = "cancelada";
        System.out.println("Reserva cancelada para " + usuario.getNombre() + " en " + espacio.getNombre());
    }

    // Getters
    public EspacioAcademico getEspacio() {
        return espacio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getEstado() {
        return estado;
    }
}