/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.mobimedlinesistema.exception;

/**
 *
 * @author juan
 */
public class ProductoInvalidoException extends RuntimeException{
    public ProductoInvalidoException(String mensaje){
        super(mensaje);
    }
}
