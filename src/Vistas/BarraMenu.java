/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author SandyG
 */
public class BarraMenu {

    JMenuBar menuBar;
    JMenu menuDesconectar, menuEdicion, menuChiribook;
    JMenuItem menuItem;

    public BarraMenu() {
        //CREO LA BARRA DE MENU
        menuBar = new JMenuBar();
        addComponentes();

    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public final void addComponentes() {

        // CREO MI PRIMERA OPCION DE MENU
        menuDesconectar = new JMenu("Desconectar");
        //establezco los nemonicos
        menuDesconectar.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuDesconectar);
        
        menuEdicion = new JMenu("Edicion");
        menuEdicion.setMnemonic(KeyEvent.VK_F1);
        menuBar.add(menuEdicion);
        
        menuChiribook = new JMenu("ChiriBook");
        menuChiribook.setMnemonic(KeyEvent.VK_C);
        menuBar.add(menuChiribook);

    }

}
