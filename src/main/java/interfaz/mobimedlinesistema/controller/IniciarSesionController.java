//Trevor was here
//Hola amiguitos del bosque. Soy Trevor y les explicare que chingaos hahce mi codigo :)
package interfaz.mobimedlinesistema.controller;

import interfaz.mobimedlinesistema.model.AgendaUsuariosBase;
import interfaz.mobimedlinesistema.model.Usuario;
import interfaz.mobimedlinesistema.app.App;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class IniciarSesionController {
    public static Usuario usuarioActual; //saber quién inició sesión

    @FXML
    private TextField tfnombreUs;

    @FXML
    private PasswordField passfiCon;

  @FXML
private void handleLogin() {
    String user = tfnombreUs.getText().trim();
    String pass = passfiCon.getText().trim();
    
    if (user.isEmpty() || pass.isEmpty()) {
        mostrarAlerta("No llenaste un campo", "Por favor, verifica tus datos.");
        return; 
    }

    List<Usuario> listaUsuarios = AgendaUsuariosBase.getUsuariosBase();
    boolean loginExitoso = false;
    
    for (Usuario u : listaUsuarios) {
        if (u.getNombreDeUsuario().equals(user) && u.getContrasenia().equals(pass)) {
            loginExitoso = true;
            usuarioActual = u; //usuario que inició sesión
            
            try {
                if (u.isPermiso()) { // Es true (Gerente)
                    System.out.println("Iniciando sesión como Gerente: " + u.getNombre());
                    App.setRoot("MenuGerente"); 
                } else { // Es false (Empleado)
                    System.out.println("Iniciando sesión como Empleado: " + u.getNombre());
                    App.setRoot("MenuVentas");
                }
            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta("ERROR DE SISTEMA", "No se pudo cargar la ventana.");
            }
            break;
        }
    }
    
    if (!loginExitoso) {
        mostrarAlerta("Credencial incorrecta", "Usuario o contraseña no válidos.");
        passfiCon.clear();
    }
}
    
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}