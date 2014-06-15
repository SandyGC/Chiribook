/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ControladorApp.ControladorMuro;
import Modelo.Publicacion;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SANGYG
 */
public class PublicacionFotoView extends javax.swing.JPanel {

    Publicacion p;
    Usuario u;
    ControladorMuro controladorM;
    ImageIcon icon;
    ResourceBundle bundle;

    /**
     * Creates new form PublicacionFotoView
     *
     * @param c
     * @param u
     * @param bundle
     */
    public PublicacionFotoView(ControladorMuro c, Usuario u, ResourceBundle bundle) {
        this.bundle = bundle;
        this.controladorM = c;
        this.u = u;
        initComponents();
        btComentar.setText(bundle.getString("comentar"));
        btExaminar.setText(bundle.getString("examinar"));
        radioTexto.setText(bundle.getString("texto"));
        this.btComentar.setEnabled(false);
        this.comentarComentario.setVisible(false);
    }

    public JButton getBtComentar() {
        return btComentar;
    }

    public void setBtComentar(JButton btComentar) {
        this.btComentar = btComentar;
    }

    public JButton getBtExaminar() {
        return btExaminar;
    }

    public void setBtExaminar(JButton btExaminar) {
        this.btExaminar = btExaminar;
    }

    public JLabel getFotoPublicacion() {
        return fotoPublicacion;
    }

    public void setFotoPublicacion(JLabel fotoPublicacion) {
        this.fotoPublicacion = fotoPublicacion;
    }

    public JRadioButton getRadioTexto() {
        return radioTexto;
    }

    public void setRadioTexto(JRadioButton radioTexto) {
        this.radioTexto = radioTexto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btComentar = new javax.swing.JButton();
        btExaminar = new javax.swing.JButton();
        radioTexto = new javax.swing.JRadioButton();
        fotoPublicacion = new javax.swing.JLabel();
        jLError = new javax.swing.JLabel();
        comentarComentario = new javax.swing.JButton();

        btComentar.setText("comentar");
        btComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComentarActionPerformed(evt);
            }
        });

        btExaminar.setText("examinar");
        btExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExaminarActionPerformed(evt);
            }
        });

        radioTexto.setText("texto");

        comentarComentario.setText("comentar-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(fotoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btExaminar)
                    .addComponent(btComentar)
                    .addComponent(radioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLError, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comentarComentario))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fotoPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btExaminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comentarComentario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btComentar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLError, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        btComentar.getAccessibleContext().setAccessibleName("btcomentar");
        btExaminar.getAccessibleContext().setAccessibleName("btexaminar");
        radioTexto.getAccessibleContext().setAccessibleName("radioTexto");
    }// </editor-fold>//GEN-END:initComponents

    private void btComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComentarActionPerformed
        // TODO add your handling code here:
        // Cambiar FOTO
        controladorM.crearPublicacionFoto(icon, u);
        fotoPublicacion.setIcon(null);

    }//GEN-LAST:event_btComentarActionPerformed

    private void btExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExaminarActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            try {
                if (f == null) {
                    jLError.setText(bundle.getString("debes_selecciona"));
                    btComentar.setEnabled(false);
                } else {
                    icon = new ImageIcon(f.toURL());
                    btComentar.setEnabled(true);
                    Image imgEscalada = icon.getImage().getScaledInstance(150,
                            150, Image.SCALE_SMOOTH);
                    Icon iconoEscalado = new ImageIcon(imgEscalada);
                    fotoPublicacion.setIcon(iconoEscalado);
                    controladorM.recibeImagen(icon);
                }
            } catch (MalformedURLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btExaminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComentar;
    private javax.swing.JButton btExaminar;
    private javax.swing.JButton comentarComentario;
    private javax.swing.JLabel fotoPublicacion;
    private javax.swing.JLabel jLError;
    private javax.swing.JRadioButton radioTexto;
    // End of variables declaration//GEN-END:variables
}
