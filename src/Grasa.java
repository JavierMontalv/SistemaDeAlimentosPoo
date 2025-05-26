public class Grasa extends Alimento implements Editable {
    public Grasa(String nombre) {
        super(nombre, "Grasas");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Grasa: " + nombre);
    }

    @Override
    public void editar(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    @Override
    public void eliminar() {
        System.out.println(nombre + " eliminado");
    }
}
