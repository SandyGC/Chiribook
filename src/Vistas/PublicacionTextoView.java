/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ControladorApp.ControladorMuro;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

/**
 *
 * @author SANGYG
 */
public class PublicacionTextoView extends javax.swing.JPanel {

    /**
     * Creates new form PublicacionMiMuro
     */
    Publicacion p;
    Usuario u;
    ControladorMuro controladorM;
    String mensaje;

    public PublicacionTextoView(ControladorMuro c, Usuario u) {
        this.controladorM = c;
        this.u = u;
        initComponents();
        obtenerTexto();
    }

    public void obtenerTexto() {

        btComentar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje = texto.getText();
                controladorM.crearPublicacion(mensaje, u);
            }
        });
    }

    public JButton getBtComentar() {
        return btComentar;
    }

    public void setBtComentar(JButton btComentar) {
        this.btComentar = btComentar;
    }

    public JRadioButton getRadioFoto() {
        return radioFoto;
    }

    public void setRadioFoto(JRadioButton radioFoto) {
        this.radioFoto = radioFoto;
    }

    public JTextPane getTexto() {
        return texto;
    }

    public void setTexto(JTextPane texto) {
        this.texto = texto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextPane();
        radioFoto = new javax.swing.JRadioButton();
        btComentar = new javax.swing.JButton();

        jScrollPane2.setViewportView(texto);

        radioFoto.setText("FOTO");

        btComentar.setText("comentar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btComentar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btComentar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioFoto))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        radioFoto.getAccessibleContext().setAccessibleName("radioFoto");
        btComentar.getAccessibleContext().setAccessibleName("btComentar");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComentar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioFoto;
    private javax.swing.JTextPane texto;
    // End of variables declaration//GEN-END:variables
}
