/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import VistaInicioSesionBD.*;
import java.util.ResourceBundle;
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
    ResourceBundle bundle;

    public ValidacionComponentes(MiPerfil vistaPerfil,ResourceBundle bundle) {
        this.vistaPerfil = vistaPerfil;
        this.bundle=bundle;
    }

    @Override
    public boolean verify(JComponent c) {
       
        JTextField field = (JTextField) c;

        boolean verify = !field.getText().isEmpty();

        if (!verify) {
            vistaPerfil.getjLErrorEdad().setText(bundle.getString("campovacio"));
            vistaPerfil.getjLErrorEmail().setText(bundle.getString("campovacio"));
            vistaPerfil.getBtGuardar().setEnabled(false);
        } else {
            vistaPerfil.getjLErrorEdad().setText("");
            vistaPerfil.getjLErrorEmail().setText("");
            vistaPerfil.getBtGuardar().setEnabled(true);
        }
        return true;
    }

}
