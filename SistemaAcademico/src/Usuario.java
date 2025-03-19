public class Usuario {
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private int edad;
    private Rol rol; // Nuevo campo para el rol

    public Usuario(String nombre, String email, String telefono, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.edad=edad;
    }

    // Método para definir la contraseña
    public void definirContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para asignar un rol
    public void asignarRol(Rol rol) {
        this.rol = rol;
    }

    public boolean validarTokenSeguridad() {
        // Lógica para validar el token de seguridad
        return true;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}