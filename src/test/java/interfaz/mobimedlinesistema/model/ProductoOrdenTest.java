package interfaz.mobimedlinesistema.model;

import interfaz.mobimedlinesistema.exception.ProductoInvalidoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductoOrdenTest {
    @Test
    void protegeLaListaYRechazaNulos() {
        List<Insumo> fuente = new ArrayList<>();
        fuente.add(new Insumo("Tornillo", 2));
        Producto producto = new Producto("SKU", "Mesa", 0, fuente);
        fuente.clear();
        assertEquals(1, producto.getInsumos().size());
        assertThrows(UnsupportedOperationException.class, () -> producto.getInsumos().clear());
        assertThrows(ProductoInvalidoException.class, () -> producto.agregarInsumo(null));
        assertThrows(ProductoInvalidoException.class, () -> new Producto("SKU", "Mesa", 0, null));
        assertThrows(ProductoInvalidoException.class,
                () -> new Producto("SKU", "Mesa", 0, Arrays.asList((Insumo) null)));
        assertThrows(ProductoInvalidoException.class, () -> producto.eliminarInsumo(1));
        producto.eliminarInsumo(0);
        assertTrue(producto.getInsumos().isEmpty());
    }

    @Test
    void mantieneValoresAnterioresAnteEntradasInvalidas() {
        Producto producto = new Producto(" Mesa ", 0);
        assertEquals("Mesa", producto.getDescripcion());
        assertThrows(ProductoInvalidoException.class, () -> producto.setDescripcion(" "));
        assertThrows(ProductoInvalidoException.class, () -> producto.setDescripcion(null));
        assertEquals("Mesa", producto.getDescripcion());
        assertThrows(ProductoInvalidoException.class, () -> producto.setCantidad(-1));
        assertEquals(0, producto.getCantidad().intValue());
        Insumo insumo = new Insumo("Tornillo", 2);
        assertThrows(IllegalArgumentException.class, () -> insumo.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> insumo.setCantidad(0));
        assertThrows(IllegalArgumentException.class, () -> insumo.setCantidadPorUnidad(-1));
        assertEquals("Tornillo", insumo.getNombre());
        assertEquals(2, insumo.getCantidad());
    }

    @Test
    void ordenesConservanCantidadesEInsumosIndependientes() {
        Producto catalogo = new Producto("Mesa");
        Insumo insumo = new Insumo("Tornillo", 2);
        catalogo.agregarInsumo(insumo);
        OrdenCompra primera = new OrdenCompra();
        OrdenCompra segunda = new OrdenCompra();
        primera.actualizarOAgregarProducto(catalogo, 3);
        segunda.actualizarOAgregarProducto(catalogo, 5);
        insumo.setCantidad(9);
        catalogo.setDescripcion("Mesa nueva");
        assertEquals(0, catalogo.getCantidad().intValue());
        assertEquals(3, primera.getProductos().get(0).getCantidad().intValue());
        assertEquals(5, segunda.getProductos().get(0).getCantidad().intValue());
        assertEquals("Mesa", primera.getProductos().get(0).getDescripcion());
        assertEquals(6, primera.obtenerTotalesPorId().get(0).getCantidad());
        assertEquals(10, segunda.obtenerTotalesPorId().get(0).getCantidad());
        primera.eliminarProducto(catalogo);
        assertTrue(primera.getProductos().isEmpty());
    }

    @Test
    void recalculaEspecialYRechazaCantidadesInvalidas() {
        Producto producto = new Producto("Mesa");
        OrdenCompra orden = new OrdenCompra();
        orden.actualizarOAgregarProducto(producto, 10);
        assertTrue(orden.getTipoEspecial());
        orden.actualizarOAgregarProducto(producto, 9);
        assertFalse(orden.getTipoEspecial());
        assertThrows(IllegalArgumentException.class, () -> orden.actualizarOAgregarProducto(producto, 0));
        assertEquals(9, orden.getProductos().get(0).getCantidad().intValue());
        orden.actualizarOAgregarProducto(producto, 10);
        orden.eliminarProducto(0);
        assertFalse(orden.getTipoEspecial());
    }

    @Test
    void consolidaPorIdentidadSinModificarInsumos() {
        Producto uno = new Producto("Uno");
        Producto dos = new Producto("Dos");
        uno.agregarInsumo(new Insumo("COMPARTIDO", "Tornillo", 2));
        dos.agregarInsumo(new Insumo("COMPARTIDO", "Tornillo", 4));
        OrdenCompra orden = new OrdenCompra();
        orden.actualizarOAgregarProducto(uno, 3);
        orden.actualizarOAgregarProducto(dos, 2);
        assertEquals(1, orden.obtenerTotalesPorId().size());
        assertEquals(14, orden.obtenerTotalesPorId().get(0).getCantidad());
        assertEquals(2, uno.getInsumos().get(0).getCantidad());
    }

    @Test
    void catalogoRechazaDuplicadosAlAgregarYEditar() {
        List<Producto> productos = CatalogoProductosBase.getProductosBase();
        Producto primero = productos.get(0);
        Producto segundo = productos.get(1);
        String original = segundo.getDescripcion();
        assertThrows(ProductoInvalidoException.class,
                () -> CatalogoProductosBase.actualizarDescripcion(segundo,
                        " " + primero.getDescripcion().toUpperCase() + " "));
        assertEquals(original, segundo.getDescripcion());
        assertThrows(ProductoInvalidoException.class,
                () -> CatalogoProductosBase.setProductosBase(new Producto(primero.getDescripcion())));
        CatalogoProductosBase.actualizarDescripcion(segundo, " " + original + " ");
        assertEquals(original, segundo.getDescripcion());
    }
}
