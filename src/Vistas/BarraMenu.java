/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import VistaInicioSesionBD.VistaInicio;
import VistaLoginApp.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.RootPaneContainer;

/**
 *
 * @author SandyG
 */
public class BarraMenu {

    private JMenuBar menuBar;
    private JMenu menuSalir, menuIdioma, menuHelp;

    private JMenuItem español, ingles, itemContenidos;

    private Login g;

    private ResourceBundle bundle;

    public BarraMenu(Login g) {
        //CREO LA BARRA DE MENU
        this.g = g;
        this.bundle = g.getBundle();
        menuBar = new JMenuBar();
        addComponentes();

    }

//--------------Metodo que devuelve la instancia del boton ayuda de la barra de menu
    public JMenuItem getBotonAyuda() {
        return itemContenidos;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
/**
 * JOption para que aprece al cambiar el menu
 */
    public final void JOptionPane() {
        JOptionPane.showOptionDialog(null,
                bundle.getString("necesita_reiniciar"),
                null,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{bundle.getString("mensajes_OK")},
                "Salir");
    }
/**
 * añadr componentes
 */
    public final void addComponentes() {       
        menuSalir = new JMenu(bundle.getString("salir"));
        //establezco los nemonicos
        menuSalir.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menuSalir);

        menuIdioma = new JMenu(bundle.getString("idioma"));
        menuIdioma.setMnemonic(KeyEvent.VK_I);
        menuBar.add(menuIdioma);
        //-----------en la barra de menu
        menuHelp = new JMenu(bundle.getString("ayuda"));

        itemContenidos = new JMenuItem(bundle.getString("contenido"));
 

        menuHelp.add(itemContenidos);

        menuBar.add(menuHelp);

        español = new JMenuItem(bundle.getString("espanol"));
        español.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                g.lenguajeActual(new String[]{"es", "ES"});
                JOptionPane();
            }
        });

        ingles = new JMenuItem(bundle.getString("ingles"));
        ingles.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                g.lenguajeActual(new String[]{"en", "EN"});
                JOptionPane();
            }
        });
        menuIdioma.add(español);
        menuIdioma.add(ingles);

    }

}
