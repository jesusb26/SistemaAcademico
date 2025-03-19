public class Docente extends Usuario {
    private String departamento;

    // Constructor
    public Docente(String nombre, String email, String telefono, int edad, String departamento) {
        super(nombre, email, telefono, edad); // Llama al constructor de la superclase
        this.departamento = departamento;
    }

    // Método específico de Docente
    public void enseñar() {
        System.out.println(getNombre() + " está enseñando en el departamento de " + departamento);
    }

    // Getter y setter específico
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}