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
