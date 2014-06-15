/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ControladorApp.ControladorMuro;
import ControladorApp.ControladorRadioButtonMuro;
import Modelo.Publicacion;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author SANGYG
 */
public class MiMuro extends javax.swing.JPanel {

    /**
     * Creates new form MiMuro
     */
    ControladorRadioButtonMuro c;
    ControladorMuro controladorMiiMuro;
    ResourceBundle bundle;

    public MiMuro(Usuario u, ResourceBundle bundle) {

        //controlador que controla los eventos del radiobutton y nececita this
        //para poder acceder a los componentes de esta vista
        c = new ControladorRadioButtonMuro(this, bundle,null);
        initComponents();
        panel2();
        //controlador que controla la vista muro y le paso this
        //para poder editar lso componentes de esta vista
        controladorMiiMuro = new ControladorMuro(this, u,bundle);
        jLnOMBRE.setText(u.getNombreCompleto());
        cargarImagen(u);
        panelCard(u, bundle);

    }

    public final void panelCard(Usuario u, ResourceBundle bundle) {

        panelPublicacion.setLayout(new CardLayout());

        PublicacionTextoView p = new PublicacionTextoView(controladorMiiMuro, u, bundle);
        panelPublicacion.add(p, bundle.getString("texto"));
        PublicacionFotoView p2 = new PublicacionFotoView(controladorMiiMuro, u, bundle);
        panelPublicacion.add(p2, bundle.getString("foto"));
        //eventos a los que responde el radiobutton
        p.getRadioFoto().addActionListener(c);
        p2.getRadioTexto().addActionListener(c);
    }

    public final void cargarImagen(Usuario u) {
        
        
        
        Image i = ImageConverter.bytes2Image(u.getFotoPerfil());
        
        Image imgEscalada = i.getScaledInstance(90,
                            90, Image.SCALE_SMOOTH);
        
        if (i != null) {
            jLFoto.setText("");
            jLFoto.setIcon(new ImageIcon(imgEscalada));
        } else {

            jLFoto.setText("No Image");
            jLFoto.setIcon(null);
        }
    }

    public final void panel2() {
        panelMuro2.setLayout(new BoxLayout(panelMuro2, BoxLayout.Y_AXIS));
    }

    public JPanel getPanelPublicacion() {
        return panelPublicacion;
    }

    public JPanel getPanelMuro2() {
        return panelMuro2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        panelPublicacion = new javax.swing.JPanel();
        jLnOMBRE = new javax.swing.JLabel();
        jLFoto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelMuro2 = new javax.swing.JPanel();

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panelPublicacionLayout = new javax.swing.GroupLayout(panelPublicacion);
        panelPublicacion.setLayout(panelPublicacionLayout);
        panelPublicacionLayout.setHorizontalGroup(
            panelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPublicacionLayout.setVerticalGroup(
            panelPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMuro2Layout = new javax.swing.GroupLayout(panelMuro2);
        panelMuro2.setLayout(panelMuro2Layout);
        panelMuro2Layout.setHorizontalGroup(
            panelMuro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        panelMuro2Layout.setVerticalGroup(
            panelMuro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelMuro2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLnOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addComponent(jScrollPane2)
            .addComponent(panelPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLnOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLnOMBRE;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelMuro2;
    private javax.swing.JPanel panelPublicacion;
    // End of variables declaration//GEN-END:variables
}
