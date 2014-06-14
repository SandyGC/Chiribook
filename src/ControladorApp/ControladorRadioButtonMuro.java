/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import Vistas.MiMuro;
import Vistas.PublicacionTextoPublicadaView;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.hsqldb.resources.BundleHandler;

/**
 *
 * @author SandyG
 */
public class ControladorRadioButtonMuro implements ActionListener {

    public static final String FOTO = "foto";
    private MiMuro m;
    private ResourceBundle bundle;
    private JPanel panel;

    public ControladorRadioButtonMuro(MiMuro m, ResourceBundle b, JPanel panel) {
        this.bundle = b;
        this.m = m;
        this.panel = panel;
    }

    /**
     * Action que cambia de paneles a FOTO o TEXTO
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();

        if (m != null) {
            if (radio.getText().equals(bundle.getString(FOTO))) {
                ((CardLayout) m.getPanelPublicacion().getLayout()).show(m.getPanelPublicacion(), "foto");
            } else {

                ((CardLayout) m.getPanelPublicacion().getLayout()).show(m.getPanelPublicacion(), "texto");
            }
        } else {
            
            if (radio.getText().equals(bundle.getString(FOTO))) {
                ((CardLayout) panel.getLayout()).show(panel, "foto");
            } else {

                ((CardLayout)panel.getLayout()).show(panel, "texto");
            }
        }

    }

}
