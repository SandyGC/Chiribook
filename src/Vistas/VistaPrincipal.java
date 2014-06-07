/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ControladorApp.ControladorMuro;
import Modelo.Usuario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author SandyG
 */
public class VistaPrincipal {
    
    private JFrame frame;
    private JSplitPane splitPane;
    JPanel panelCards;
    JScrollPane scrollPane;
    
  
    
    public VistaPrincipal(Usuario u) {
    
        construirSplitPane();
        construirPanelIzquierdo();
        construirPanelDerecho(u);
        construirVentana();
        construirBarraMenu();
    }

   

    /**
     * Metodo que construye la barra de menu
     */
    public final void construirBarraMenu() {
        BarraMenu barraMenu = new BarraMenu();
        //edito la barra de menu del jframe
        frame.setJMenuBar(barraMenu.getMenuBar());
    }

    /**
     * Metodo que construye la ventana
     */
    public final void construirVentana() {
//1. Create the frame.
        frame = new JFrame("CHIRIBOOK");
        frame.setLayout(new BorderLayout());
//2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//le doy tamaño a la ventana y establezco donde aparecerá la ventana
        frame.setBounds(150, 150, 900, 500);
//5. Show it.
        frame.setResizable(true);
        frame.setVisible(true);
        
        frame.add(splitPane);
        
    }
    
    public final void construirSplitPane() {
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        
    }
    
    public final void construirPanelIzquierdo() {
        PanelIzquierdo pane = new PanelIzquierdo(this);
        splitPane.add(pane.getPanelIz());
    }
    
    public final void construirPanelDerecho(Usuario u) {
        //panel que contiene los 4 paneles

        panelCards = new JPanel();
        JPanel muro = new MiMuro(u);
        JPanel miPerfil = new MiPerfil();
        panelCards.setLayout(new CardLayout());
        panelCards.add(muro, "muro");
        panelCards.add(miPerfil, "perfil");
        scrollPane = new JScrollPane(panelCards);
        //para editar el scroll bar que aparezca solo de arriba a abjo.
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        splitPane.add(scrollPane);
        
    }
    
    public JPanel getPanelCards() {
        return panelCards;
    }
    
}
