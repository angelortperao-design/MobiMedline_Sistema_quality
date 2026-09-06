package interfaz.mobimedlinesistema.model;

import java.util.ArrayList;
import interfaz.mobimedlinesistema.exception.ProductoInvalidoException;

import java.util.List;

public class Producto {
    // --- Atributos ---
    private static int contadorSiguiente = 1;

    private final String sku;
    private String descripcion;
    private int cantidad;
    private final List<Insumo> insumos;

    // --- Constructor ---
    public Producto(String descripcion, int cantidad) {
        this(String.format("%05d", contadorSiguiente++),
             descripcion, cantidad, new ArrayList<>());
    }


    public Producto(String nombre) {
        this(String.format("%05d", contadorSiguiente++),
             nombre, 0, new ArrayList<>());
    }

    public Producto(String sku, String descripcion, int cantidad, List<Insumo> insumos) {
        if(sku == null || sku.isBlank()){
            throw new ProductoInvalidoException("El sku está vacío.");
        }
        descripcion = validarDescripcion(descripcion);
        validarCantidad(cantidad);
        if (insumos == null) {
            throw new ProductoInvalidoException("La lista de insumos no puede ser nula.");
        }

        List<Insumo> copia = new ArrayList<>(insumos);

        if (copia.stream().anyMatch(insumo -> insumo == null)) {
            throw new ProductoInvalidoException("La lista no puede contener insumos nulos.");
        }

        this.sku = sku;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.insumos = copia;
    }

    /**
     * Agrega una instancia de Insumo a nuestra lista List<Insumo> insumos
     * @param insumo Insumo a agregar en nuestra lista de insumos
     * @author Ale, Javi, Vero
     */
    public void agregarInsumo(Insumo insumo){
        if(insumo == null){
            throw new ProductoInvalidoException("El insumo no debe estar vacío.");
        }
        this.insumos.add(insumo);
    }

    /**
     * Elimina un una instancia de tipo Insumo de nuestra List<Insumo> insumos;
     * @param index Indice de Insumo a remover
     * @author Ale, Javi, Vero
     */
    public void eliminarInsumo(int index) {
        if (index < 0 || index >= insumos.size()) {
            throw new ProductoInvalidoException("El índice del insumo está fuera de rango.");
        }
        insumos.remove(index);
    }

    // --- Getters
    public String getDescripcion() {
        return descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getSku() {
        return this.sku;
    }

    public List<Insumo> getInsumos() {
      return List.copyOf(insumos);
    }


    // --- Setters
    public void setCantidad(int cantidad) {
        validarCantidad(cantidad);
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion){
        descripcion = validarDescripcion(descripcion);
        this.descripcion = descripcion;
    }

    static String validarDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new ProductoInvalidoException("La descripción del producto está vacía.");
        }
        return descripcion.strip();
    }

    private static void validarCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new ProductoInvalidoException("La cantidad de productos no debe ser menor a cero.");
        }
    }

    public Producto copiarConCantidad(int cantidad) {
      List<Insumo> copias = new ArrayList<>();

      for (Insumo insumo : insumos) {
          copias.add(new Insumo(
                  insumo.getIdInsumo(),
                  insumo.getNombre(),
                  insumo.getCantidadPorUnidad()));
      }

      return new Producto(sku, descripcion, cantidad, copias);
  }


    //Clase de agregar producto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{sku='").append(sku).append("', nombre='").append(descripcion).append("', insumos=[");
        for (int i = 0; i < insumos.size(); i++) {
            sb.append(insumos.get(i).toString());
            if (i < insumos.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }

}
