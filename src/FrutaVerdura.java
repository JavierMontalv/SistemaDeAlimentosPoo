public class FrutaVerdura extends Alimento {
    public FrutaVerdura(String nombre) {
        super(nombre, "Frutas y verduras");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Fruta/Verdura: " + nombre);
    }
}
