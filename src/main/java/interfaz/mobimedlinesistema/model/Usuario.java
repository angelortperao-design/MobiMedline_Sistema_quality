/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.mobimedlinesistema.model;
import interfaz.mobimedlinesistema.exception.UsuarioInvalidoException;
/**
 *
 * @author Mike
 */
public class Usuario {
    // --- Atributos --- 
    private String nombreDeUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenia;
    private boolean permiso; //true representa que es el gerente y al iniciar sesión abre el MenuGerente.
    //false representa que es un empleado y abre MenuVentas.
    
    // --- Constructor ---
    public Usuario(String nombreDeUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenia){
        this.nombreDeUsuario = validarCampo(nombreDeUsuario, "nombre de usuario"); 
        this.nombre = validarCampo(nombre, "nombre");
        this.apellidoPaterno = validarCampo(apellidoPaterno, "apellido paterno");
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = validarCampo(contrasenia, "contraseña");
        permiso = false;
    }
    
    // --- Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean isPermiso() {
        return permiso;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    
    
    // --- Setters
    public void setNombre(String nombre) {
        this.nombre = validarCampo(nombre, "nombre");
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = validarCampo(apellidoPaterno, "apellido paterno");
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = validarCampo(contrasenia, "contraseña");
    }

    public void setPermiso(boolean permiso) {
        this.permiso = permiso;
    }   

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = validarCampo(nombreDeUsuario, "usuario");
    }
    
    private static String validarCampo(String valor, String campo){
        if(valor == null || valor.isBlank()){
            throw new UsuarioInvalidoException("El campo " + campo + " no puede estar vacío.");
        }
        return valor;
    }
    
}
