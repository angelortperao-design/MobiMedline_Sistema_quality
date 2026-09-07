/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.mobimedlinesistema.model;

import interfaz.mobimedlinesistema.model.CatalogoProductosBase;
import interfaz.mobimedlinesistema.model.OrdenCompra;
import interfaz.mobimedlinesistema.model.Producto;
import interfaz.mobimedlinesistema.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Clase dedicada a guardar las OrdenCompra cargados en el codigo y las que se generen
 * @author Mike
 */
public class ArchivoOdcBase {
    private static ObservableList<OrdenCompra> odcBase = FXCollections.observableArrayList();
    
    // Bloque estático para inicializar las OrdenCompra base una sola vez
    
    static {
        //aqui va las OrdenCompra base a mostrar en la expo
        List<Producto> productos = CatalogoProductosBase.getProductosBase();
        List<Usuario> directorioUsuarios = AgendaUsuariosBase.getUsuariosBase();
        //aquí se hicieron los cambios
        //  OrdenCompra 1 
        OrdenCompra odc1 = new OrdenCompra(directorioUsuarios.get(0), "2026-04-25", "Pendiente");
        odc1.actualizarOAgregarProducto(productos.get(0),3); // Vitrina Futuro
        odc1.actualizarOAgregarProducto(productos.get(2),1); // Escalerilla
        odcBase.add(odc1);

        //  OrdenCompra 2 
        OrdenCompra odc2 = new OrdenCompra(directorioUsuarios.get(1), "2026-04-25", "Emitida");
        odc2.actualizarOAgregarProducto(productos.get(1),4); // Mesa Premium
        odc2.actualizarOAgregarProducto(productos.get(3),2); // Silla
        odcBase.add(odc2);

        //  OrdenCompra 3 
        OrdenCompra odc3 = new OrdenCompra(directorioUsuarios.get(2), "2026-04-25", "Pendiente");
        odc3.actualizarOAgregarProducto(productos.get(0),1); // Vitrina
        odc3.actualizarOAgregarProducto(productos.get(1),5); // Mesa
        odc3.actualizarOAgregarProducto(productos.get(2),10); // Escalerilla
        odcBase.add(odc3);
    }

    public static ObservableList<OrdenCompra> getOdcBase() {
    return odcBase;
    }
    
    public static void actualizarODC(OrdenCompra odcActualizada) {
    for (int i = 0; i < odcBase.size(); i++) {
        if (odcBase.get(i).getIdODC().equals(odcActualizada.getIdODC())) {
            odcBase.set(i, odcActualizada);
            return;
        }
      }
    }
    
    public static void agregarODC(OrdenCompra odc) {
    odcBase.add(odc);
    }
}

    

