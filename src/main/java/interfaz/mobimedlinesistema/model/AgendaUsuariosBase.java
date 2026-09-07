/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.mobimedlinesistema.model;

import interfaz.mobimedlinesistema.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase dedicada a guardar los usuarios cargados en el codigo
 * @author Mike
 */
public class AgendaUsuariosBase {
    private static List<Usuario> usuariosBase = new ArrayList<>();
    
    //Se agrego para hacer un puente que cuando se modifique algo se guarde directamente en esta clase de base 
    public static void setUsuariosBase(List<Usuario> nuevaLista) {
    usuariosBase = nuevaLista;
    }
    
    // Bloque estático para inicializar los Usuario base una sola vez
    static {
        // --- Usuario Base: Gerente ---
        Usuario usuario1 = new Usuario("1", "Jhon", "Dhoe", "Smith", "1");
        usuario1.setPermiso(true); // Damos permiso de administrador
        // Se crea con la plantilla
        usuariosBase.add(usuario1);
        
        // --- Usuario Base: usuario ---
        Usuario usuario2 = new Usuario("2", "Miguel Angel", "Pérez", "Smith", "2");
        // Se crea con la plantilla
        usuariosBase.add(usuario2);
        
        // --- Usuario Base: usuario ---
        Usuario usuario3 = new Usuario("RAAA01", "Alejandro Rodolfo", "Ramirez", "Arzate", "1Oney");
        // Se crea con la plantilla
        usuariosBase.add(usuario3);
        
        // --- Usuario Base: usuario ---
        Usuario usuario4 = new Usuario("GAGV01", "Veronica", "Garcia", "Gonzalez", "n0th1ng");
        // Se crea con la plantilla
        usuariosBase.add(usuario4);
    }
    
    public static List<Usuario> getUsuariosBase() {
        return usuariosBase;
    }
    
}
