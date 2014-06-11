/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import VistaInicioSesionBD.*;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SandyG
 */
public class ValidacionComponentes extends InputVerifier {

    MiPerfil vistaPerfil;

    public ValidacionComponentes(MiPerfil vistaPerfil) {
        this.vistaPerfil = vistaPerfil;
    }

    @Override
    public boolean verify(JComponent c) {
       
        JTextField field = (JTextField) c;

        boolean verify = !field.getText().isEmpty();

        if (!verify) {
            vistaPerfil.getjLErrorEdad().setText("El campo no puede ser vacio");
            vistaPerfil.getjLErrorEmail().setText("El campo no puede ser vacio");
            vistaPerfil.getBtGuardar().setEnabled(false);
        } else {
            vistaPerfil.getjLErrorEdad().setText("");
            vistaPerfil.getjLErrorEmail().setText("");
            vistaPerfil.getBtGuardar().setEnabled(true);
        }
        return true;
    }

}
