/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaLoginApp;

import ControladorLogin.ControladorLogin;
import Modelo.Usuario;
import Vistas.BarraMenu;
import Vistas.VistaPrincipal;
import static java.awt.Event.F1;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author SANGYG
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    ValidacionComponentesLogin validacion;
    ControladorLogin controladorLogin;
    private static final String LANG = "lang";
    private static final String COUNTRY = "country";
    private static final String NOMBRE = "nombre";
    private static final String PASS = "pass";
    private BarraMenu b;
    // Preferencias para la clase
    static final Preferences preferencias
            = Preferences.userRoot().node(Login.class.getName());
    ResourceBundle bundle;

    public Login() {
        cargarLenguaje();
        initComponents();
        jlabelNombre.setText(bundle.getString("nombre"));
        jlabelPass.setText(bundle.getString("pass"));
        btConectar.setText(bundle.getString("conectar"));
        obtenerDatosUsuario();
        crearBarraMenu(this);
        validacion = new ValidacionComponentesLogin(this);
        controladorLogin = new ControladorLogin(this);
        cargarFoto();
        comprobarcamposVacios();
        iniciarSesion();
    }
/**
 * Metodo que comprueba campos vacios
 */
    public final void comprobarcamposVacios() {
        this.btConectar.setEnabled(false);
        this.jtNombre.setInputVerifier(validacion);
        this.jtPass.setInputVerifier(validacion);
    }
/**
 * Metodoq ue crea la barra de menu
 * @param g 
 */
    public void crearBarraMenu(Login g) {
        b = new BarraMenu(g);
        this.setJMenuBar(b.getMenuBar());
        cargarAyuda();
    }
/**
 * Metodo que carga la foto
 */
    public void cargarFoto() {
        ImageIcon imgIcon = new ImageIcon("IMAGENES/chribook.png");

        Image imgEscalada = imgIcon.getImage().getScaledInstance(jLabelFoto.getWidth(),
                jLabelFoto.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        jLabelFoto.setIcon(iconoEscalado);

    }

    /**
     * Metodo que cargara los ficheros de ayuda y establecera los botones para
     * acceder a ella.
     */
    private void cargarAyuda() {
        try {
            // Carga el fichero de ayuda 
            File fichero = new File("javaHelp/help_set.hs");
            URL hsURL = fichero.toURI().toURL();
          //   Crea el HelpSet y el HelpBroker       
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            // Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem 
            hb.enableHelpOnButton(b.getBotonAyuda(), "Chiribook", helpset);
            hb.enableHelpKey(this.getContentPane(), "Chiribook", helpset);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que inicia sesion en la aplicacion si existe el usuario
     */
    public final void iniciarSesion() {
        btConectar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario a = controladorLogin.buscarUsuario();
                if (a == null) {
                    jLErrorInici.setText(bundle.getString("existe_usuario"));
                } else {

                    jLErrorInici.setText(bundle.getString("saludo"));
                    almacenarDatosUsuario();
                    VistaPrincipal v = new VistaPrincipal(bundle, a);
                    cerrarVista();
                }

            }
        });
    }

    public void cerrarVista() {
        this.dispose();
    }
/**
 * Metodo que carga el lengua
 */
    public final void cargarLenguaje() {
        Locale currentLocale = lenguajeActual(new String[]{""});
        bundle = ResourceBundle.getBundle("Resources/Bundle", currentLocale);

    }

    public JTextField getJtNombre() {
        return jtNombre;
    }

    public JPasswordField getJtPass() {
        return jtPass;
    }
    
/**
 * metodo que comprueba el lenguaje actual
 * @param args
 * @return 
 */
    public Locale lenguajeActual(String[] args) {
        String language;
        String country;

        // Si no se pasa por argumento, intenta obtenerlo
        // del fichero de propiedades
        if (args.length != 2) {
            language = preferencias.get(LANG, "en");
            country = preferencias.get(COUNTRY, "EN");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);

            // Si se ha pasado como argumento, 
            // lo guarda en el fichero de propiedades
            preferencias.put(LANG, language);
            preferencias.put(COUNTRY, country);
        }

        return new Locale(language, country);
    }
/**
 * Almacenar datos en las preferencias
 */
    public void almacenarDatosUsuario() {

        preferencias.put(NOMBRE, jtNombre.getText());
        preferencias.put(PASS, new String(jtPass.getPassword()));

    }

    public Login(JTextField jtNombre, JPasswordField jtPass) {
        this.jtNombre = jtNombre;
        this.jtPass = jtPass;
    }


    
/**
 * Obtener datos de las preffrencias
 */
    public void obtenerDatosUsuario() {
        String nombre = preferencias.get(NOMBRE, "");
        this.jtNombre.setText(nombre);
        String pass = preferencias.get(PASS, "");
        this.jtPass.setText(pass);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabelNombre = new javax.swing.JLabel();
        jlabelPass = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtPass = new javax.swing.JPasswordField();
        btConectar = new javax.swing.JButton();
        btAltaUsuario = new javax.swing.JButton();
        errorNombre = new javax.swing.JLabel();
        errorPass = new javax.swing.JLabel();
        jLErrorInici = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabelNombre.setText("Nombre :");

        jlabelPass.setText("Contraseña: ");

        jLabelFoto.setText("jLabel1");

        btConectar.setText("CONECTAR");

        btAltaUsuario.setText("Nuevo Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabelPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLErrorInici, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtNombre)
                                    .addComponent(jtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                .addComponent(btConectar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAltaUsuario)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(errorNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorPass, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(errorPass, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jLErrorInici, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConectar)
                    .addComponent(btAltaUsuario))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAltaUsuario;
    private javax.swing.JButton btConectar;
    private javax.swing.JLabel errorNombre;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel jLErrorInici;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jlabelNombre;
    private javax.swing.JLabel jlabelPass;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JPasswordField jtPass;
    // End of variables declaration//GEN-END:variables


    public JButton getBtConectar() {
        return btConectar;
    }

    public JLabel getJlabelNombre() {
        return jlabelNombre;
    }

    public JLabel getJlabelPass() {
        return jlabelPass;
    }


}
