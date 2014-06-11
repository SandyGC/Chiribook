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

    JMenuBar menuBar;
    JMenu menuDesconectar, menuEdicion, menuChiribook,
            menuIdioma, submenu;
    JMenuItem menuItem;
    private ResourceBundle bundle;
    // Preferencias para la clase
    static final Preferences preferencias
            = Preferences.userRoot().node(BarraMenu.class.getName());
    private static final String LANG = "LANG2";
    private static final String COUNTRY = "COUNTRY2";
    Login g;

    public BarraMenu(Login g) {
        //CREO LA BARRA DE MENU
        this.g = g;
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

        menuIdioma = new JMenu("Idioma");
        menuChiribook.setMnemonic(KeyEvent.VK_I);
        menuBar.add(menuIdioma);

    }

    private void initLocale() {
        // Obtengo las preferencias del usuario
        Preferences userPreferences = Preferences.userRoot();
        // Obtengo un valor de preferencias 
        String lang = userPreferences.get(LANG, "es");
        String country = userPreferences.get(COUNTRY, "ES");

        bundle = ResourceBundle.getBundle(
                "Resources/Bundle_" + lang + "_" + country);

        Locale.setDefault(new Locale(lang, country));
    }

    private void changeLanguage(String language, String country) {
        Preferences userPreferences = Preferences.userRoot();

        // Guardo un valor en preferencias 
        userPreferences.put(LANG, language);
        userPreferences.put(COUNTRY, country);

        JOptionPane.showConfirmDialog(g, bundle.getString("NECESITA_REINICIAR"));
    }

}
