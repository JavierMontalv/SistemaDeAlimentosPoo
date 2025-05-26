// Superclase
public abstract class Alimento {
    protected String nombre;
    protected String categoria;

    public Alimento(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }

    public abstract void mostrarInfo();
}
