/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaLoginApp;

import VistaInicioSesionBD.VistaInicio;
import java.util.ResourceBundle;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SandyG
 */
public class ValidacionComponentesLogin extends InputVerifier {

    Login vista;
    ResourceBundle bundle;

    public ValidacionComponentesLogin(Login vista,ResourceBundle bundle) {
        this.vista = vista;
        this.bundle=bundle;
    }

    @Override
    public boolean verify(JComponent c) {
  JTextField field = (JTextField) c;

        boolean verify = field.getText().isEmpty();
   
        if (verify) {
            vista.getErrorNombre().setText(bundle.getString("campovacio"));
            vista.getBtConectar().setEnabled(false);
        }  if (verify) {
            vista.getErrorPass().setText(bundle.getString("campovacio"));
            vista.getBtConectar().setEnabled(false);
        } else if(!verify){
            vista.getErrorNombre().setText("");
            vista.getErrorPass().setText("");
            vista.getBtConectar().setEnabled(true);
        }
        return true;
     
    }
    
      

}
