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
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import static javax.swing.text.html.HTML.Attribute.LANG;

/**
 *
 * @author SandyG
 */
public class VistaPrincipal {

    private JFrame frame;
    private JSplitPane splitPane;
    private JPanel panelCards;
    private JMenuBar barraMenu;

    public VistaPrincipal(ResourceBundle bundle,Usuario u,JMenuBar barraMenu) {
        this.barraMenu=barraMenu;
        construirSplitPane();
        construirPanelIzquierdo(bundle);
        construirPanelDerecho(bundle,u);
        construirVentana();
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
        frame.setJMenuBar(barraMenu);
//le doy tamaño a la ventana y establezco donde aparecerá la ventana
        frame.setBounds(150, 150, 900, 500);
//5. Show it.
        frame.setResizable(false);
        frame.setVisible(true);
     
        frame.add(splitPane);

    }

    public final void construirSplitPane() {
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);

    }

    public final void construirPanelIzquierdo(ResourceBundle bundle) {
        PanelIzquierdo pane = new PanelIzquierdo(bundle,this);
        splitPane.add(pane.getPanelIz());
    }

    public final void construirPanelDerecho(ResourceBundle bundle,Usuario u) {
        //panel que contiene los 4 paneles

        panelCards = new JPanel();
        JPanel muro = new MiMuro(u,bundle);
        JPanel miPerfil = new MiPerfil(u,bundle);
        JPanel misAmigos = new MisAmigos(u,bundle);
        JPanel buscarUsuarios= new BuscarUsuarios(u,bundle);
        JPanel misGustos=new MisGustos(bundle);

        panelCards.setLayout(new CardLayout());
        panelCards.add(muro, "muro");
        panelCards.add(miPerfil, "perfil");
        panelCards.add(misAmigos, "amigos");
        panelCards.add(buscarUsuarios,"buscarUsuarios");
        panelCards.add(misGustos,"misGustos");
        splitPane.add(panelCards);

    }

    public JPanel getPanelCards() {
        return panelCards;
    }
    public void recuperarBundel(){
    
    
    }

}
