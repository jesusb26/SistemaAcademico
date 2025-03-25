import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaMensaje {
    private List<Mensaje> mensajes; // Lista de mensajes privados
    private List<Foro> foros;       // Lista de foros

    public SistemaMensaje() {
        this.mensajes = new ArrayList<>();
        this.foros = new ArrayList<>();
    }

    // Método para enviar un mensaje privado
    public void enviarMensaje(Usuario remitente, List<Usuario> destinatarios, String asunto, String contenido, String fechaEnvio, String tipo) {
        Mensaje mensaje = new Mensaje(remitente, destinatarios, asunto, contenido, fechaEnvio, tipo);
        if (mensaje.enviarMensaje()) {
            mensajes.add(mensaje);
        }
    }

    // Método para obtener mensajes recibidos por un usuario
    public List<Mensaje> obtenerMensajesRecibidos(Usuario usuario) {
        return mensajes.stream()
                .filter(m -> m.getDestinatarios().contains(usuario)) // Filtra mensajes donde el usuario es destinatario
                .collect(Collectors.toList());
    }

    // Método para buscar mensajes por fecha
    public List<Mensaje> buscarMensajesPorFecha(Usuario usuario, String fecha) {
        return mensajes.stream()
                .filter(m -> m.getDestinatarios().contains(usuario) && m.getFechaEnvio().equals(fecha))
                .collect(Collectors.toList());
    }

    // Método para buscar mensajes por remitente
    public List<Mensaje> buscarMensajesPorRemitente(Usuario usuario, Usuario remitente) {
        return mensajes.stream()
                .filter(m -> m.getDestinatarios().contains(usuario) && m.getRemitente().equals(remitente))
                .collect(Collectors.toList());
    }

    // Método para crear un nuevo foro
    public void crearForo(String nombre) {
        Foro foro = new Foro(nombre);
        foros.add(foro);
    }

    // Método para publicar un mensaje en un foro
    public void publicarMensajeEnForo(String nombreForo, Usuario remitente, String contenido) {
        Foro foro = foros.stream()
                .filter(f -> f.getNombre().equals(nombreForo))
                .findFirst()
                .orElse(null);

        if (foro != null) {
            foro.publicarMensaje(remitente, contenido);
        } else {
            System.out.println("Foro no encontrado: " + nombreForo);
        }
    }

    // Método para obtener mensajes de un foro
    public List<Mensaje> obtenerMensajesDeForo(String nombreForo) {
        Foro foro = foros.stream()
                .filter(f -> f.getNombre().equals(nombreForo))
                .findFirst()
                .orElse(null);

        if (foro != null) {
            return foro.obtenerMensajes();
        } else {
            System.out.println("Foro no encontrado: " + nombreForo);
            return new ArrayList<>();
        }
    }

    // Método para listar todos los foros
    public List<String> listarForos() {
        return foros.stream()
                .map(Foro::getNombre)
                .collect(Collectors.toList());
    }
}