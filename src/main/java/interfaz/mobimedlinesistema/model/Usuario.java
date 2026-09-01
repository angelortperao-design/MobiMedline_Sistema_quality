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
    private String usuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contrasenia;
    private boolean permiso; 
    
    // --- Constructor ---
    public Usuario(String usuario, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasenia){
        this.usuario = validarCampo(usuario, "usuario"); 
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

    public String getUsuario() {
        return usuario;
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

    public void setPermiso(boolean tipoUsuario) {
        this.permiso = tipoUsuario;
    }   

    public void setUsuario(String usuario) {
        this.usuario = validarCampo(usuario, "usuario");
    }
    
    private static String validarCampo(String valor, String campo){
        if(valor == null || valor.isBlank()){
            throw new UsuarioInvalidoException("El campo " + campo + " no puede estar vacío.");
        }
        return valor;
    }
    
}
