/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaLoginApp;

import VistaInicioSesionBD.VistaInicio;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SandyG
 */
public class ValidacionComponentesLogin extends InputVerifier {

    Login vista;

    public ValidacionComponentesLogin(Login vista) {
        this.vista = vista;
    }

    @Override
    public boolean verify(JComponent c) {

        JTextField field = (JTextField) c;

        boolean verify = !field.getText().isEmpty();

        if (!verify) {
            vista.getErrorNombre().setText("No puede ser vacio");
            vista.getErrorPass().setText("No puede ser vacio");
            vista.getBtConectar().setEnabled(false);
        } else {
            vista.getErrorNombre().setText("");
             vista.getErrorPass().setText("");
            vista.getBtConectar().setEnabled(true);
        }
        return true;
    }

}
