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
        if(usuario == null || usuario.isBlank()){
            throw new UsuarioInvalidoException("El usuario está vacío.");
        }
        if(nombre == null || nombre.isBlank()){
            throw new UsuarioInvalidoException("El nombre está vacío.");
        }
        if(apellidoPaterno == null || apellidoPaterno.isBlank()){
            throw new UsuarioInvalidoException("El apellido paterno está vacío.");
        }
        if(contrasenia == null || contrasenia.isBlank()){
            throw new UsuarioInvalidoException("La contraseña está vacía.");
        }
        this.usuario = usuario; 
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasenia = contrasenia;
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
        if(nombre == null || nombre.isBlank()){
            throw new UsuarioInvalidoException("El nombre está vacío.");
        }
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if(apellidoPaterno == null || apellidoPaterno.isBlank()){
            throw new UsuarioInvalidoException("El apellido paterno está vacío.");
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setContrasenia(String contrasenia) {
        if(contrasenia == null || contrasenia.isBlank()){
            throw new UsuarioInvalidoException("La contraseña está vacía.");
        }
        this.contrasenia = contrasenia;
    }

    public void setPermiso(boolean tipoUsuario) {
        this.permiso = tipoUsuario;
    }   

    public void setUsuario(String usuario) {
        if(usuario == null || usuario.isBlank()){
            throw new UsuarioInvalidoException("El usuario está vacío.");
        }
        this.usuario = usuario;
    }
    
}
