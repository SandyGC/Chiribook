/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author SANGYG
 */
public class PanelUsuario extends javax.swing.JPanel {

    /**
     * Creates new form PanelUsuario
     *
     * @param u
     */
    public PanelUsuario(Usuario u) {
        initComponents();
        rellenarPanel(u);
    }

    public final void rellenarPanel(Usuario u) {
        jLNombre.setText(u.getNombreCompleto());
        if (u.getFotoPerfil() == null) {
            jLFoto.setText("No Image");
        } else {
            ImageIcon imgIcon = new ImageIcon(u.getFotoPerfil());
           
            jLFoto.setIcon(imgIcon);
        }

    }

    public JButton getBtAñadirAmigo() {
        return btAñadirAmigo;
    }

    public JButton getBtVisitarPerfil() {
        return btVisitarPerfil;
    }

    public JLabel getjLFoto() {
        return jLFoto;
    }

    public JLabel getjLNombre() {
        return jLNombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLFoto = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        btVisitarPerfil = new javax.swing.JButton();
        btAñadirAmigo = new javax.swing.JButton();

        jLFoto.setText("jLabel1");

        btVisitarPerfil.setText("VistarPerfil");

        btAñadirAmigo.setText("Añadir Amigo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btVisitarPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAñadirAmigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAñadirAmigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVisitarPerfil))
                    .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAñadirAmigo;
    private javax.swing.JButton btVisitarPerfil;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLNombre;
    // End of variables declaration//GEN-END:variables
}
