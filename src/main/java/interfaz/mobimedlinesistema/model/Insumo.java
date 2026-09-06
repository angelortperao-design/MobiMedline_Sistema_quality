package interfaz.mobimedlinesistema.model;

/** Insumo y cantidad requerida por unidad de producto. */
public class Insumo {
    private static int contadorSiguiente = 1;

    private final String idInsumo;
    private String nombre;
    private int cantidad;

    public Insumo(String nombre, int cantidadPorUnidad) {
        this(String.format("%05d", contadorSiguiente++), nombre, cantidadPorUnidad);
    }

    /** Conserva la identidad al copiar un insumo para una orden. */
    public Insumo(String id, String nombre, int cantidadPorUnidad) {
        this.idInsumo = validarTexto(id, "El identificador");
        setNombre(nombre);
        setCantidadPorUnidad(cantidadPorUnidad);
    }

    public String getIdInsumo() {
        return idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadPorUnidad() {
        return cantidad;
    }

    public int getCantidad() {
        return getCantidadPorUnidad();
    }

    public void setNombre(String nombre) {
        this.nombre = validarTexto(nombre, "El nombre del insumo");
    }

    public void setCantidadPorUnidad(int cantidadPorUnidad) {
        if (cantidadPorUnidad <= 0) {
            throw new IllegalArgumentException("La cantidad del insumo debe ser mayor que cero.");
        }
        this.cantidad = cantidadPorUnidad;
    }

    public void setCantidad(int cantidad) {
        setCantidadPorUnidad(cantidad);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.strip();
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad + " unidades";
    }
}
