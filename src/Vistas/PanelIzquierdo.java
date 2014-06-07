/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Modelo.Usuario;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author SandyG
 */
public class PanelIzquierdo {

    JPanel panelIz;
    VistaPrincipal vista;
    public JPanel getPanelIz() {
        return panelIz;
    }

    public PanelIzquierdo(VistaPrincipal v) {
        vista=v;
        this.panelIz = new JPanel();
        panelIz.setLayout(new BorderLayout());
        ImageIcon icono = new ImageIcon("IMAGENES/chribook.png");
        JLabel label = new JLabel(icono);
        panelIz.add(label, BorderLayout.PAGE_START);
        construirJList();
    }
    
    public final void construirJList(){
    ListaSeleccion lista= new ListaSeleccion(vista);
    panelIz.add(lista.getLista(),BorderLayout.CENTER);
    }
    
}
