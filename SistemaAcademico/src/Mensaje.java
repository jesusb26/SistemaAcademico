import java.util.List;

public class Mensaje {
    private Usuario remitente;
    private List<Usuario> destinatarios;
    private String asunto;
    private String contenido;
    private String fechaEnvio;
    private boolean leido;
    private String tipo;

    public Mensaje(Usuario remitente, List<Usuario> destinatarios, String asunto, String contenido, String fechaEnvio, String tipo) {
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
        this.leido = false;
        this.tipo = tipo;
    }

    public boolean enviarMensaje() {
        // Lógica para enviar el mensaje
        return true; // Supongamos que el envío siempre es exitoso
    }

    public void marcarComoLeido() {
        this.leido = true;
    }

    public Mensaje responderMensaje(String nuevoContenido) {
        return new Mensaje(this.destinatarios.get(0), this.remitente, "Re: " + this.asunto, nuevoContenido, "FechaActual", this.tipo);
    }

    // Getters y setters
    public Usuario getRemitente() {
        return remitente;
    }

    public List<Usuario> getDestinatarios() {
        return destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public String getTipo() {
        return tipo;
    }
}