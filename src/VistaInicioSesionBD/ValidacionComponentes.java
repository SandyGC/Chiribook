/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaInicioSesionBD;

import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SandyG
 */
public class ValidacionComponentes extends InputVerifier {

    VistaInicio vista;

    public ValidacionComponentes(VistaInicio vista) {
        this.vista = vista;
    }
//VERIFICA LOS COMPONENTES
    @Override
    public boolean verify(JComponent c) {

        JTextField field = (JTextField) c;

        boolean verify = field.getText().isEmpty();

        if (verify) {
            vista.getErrorHost().setText("El campo no puede ser vacio");
            vista.getBtConectar().setEnabled(false);
        }
        if (verify) {
            vista.getErrorPassword().setText("El campo no puede ser vacio");
            vista.getBtConectar().setEnabled(false);
        } else if (!verify) {
            vista.getErrorHost().setText("");
            vista.getErrorPassword().setText("");
            vista.getBtConectar().setEnabled(true);
        }
        return true;
    }

}
