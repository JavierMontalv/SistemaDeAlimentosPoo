public class HidratoCarbono extends Alimento {
    public HidratoCarbono(String nombre) {
        super(nombre, "Hidratos de carbono");
    }
    @Override
    public void mostrarInfo() {
        System.out.println("Hidrato de carbono: " + nombre);
    }
}
