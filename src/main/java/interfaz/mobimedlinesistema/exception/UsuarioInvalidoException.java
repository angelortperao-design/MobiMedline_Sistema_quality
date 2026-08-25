/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.mobimedlinesistema.exception;

/**
 *
 * @author juan
 */
public class UsuarioInvalidoException extends RuntimeException{
    public UsuarioInvalidoException(String mensaje){
        super(mensaje);
    }
}
