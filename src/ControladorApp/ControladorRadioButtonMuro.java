/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import Vistas.MiMuro;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author SandyG
 */
public class ControladorRadioButtonMuro implements ActionListener {

    public static final String FOTO = "FOTO";
    MiMuro m;

    public ControladorRadioButtonMuro(MiMuro m) {
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        System.out.println(radio.getText());
        if (radio.getText().equals(FOTO)) {
            ((CardLayout) m.getPanelMuro1().getLayout()).show(m.getPanelMuro1(), "foto");
        } else {

            ((CardLayout) m.getPanelMuro1().getLayout()).show(m.getPanelMuro1(), "texto");
        }

    }

}
