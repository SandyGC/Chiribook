/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author SANGYG
 */
public class PublicacionFotoView extends javax.swing.JPanel {

    /**
     * Creates new form PublicacionFotoView
     */
    public PublicacionFotoView() {
        initComponents();

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

        fotoPublicacion = new javax.swing.JLabel();
        btComentar = new javax.swing.JButton();
        btExaminar = new javax.swing.JButton();
        radioTexto = new javax.swing.JRadioButton();

        fotoPublicacion.setText("foto");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(fotoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btComentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addComponent(btExaminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btComentar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioTexto)
                .addGap(17, 17, 17))
            .addComponent(fotoPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fotoPublicacion.getAccessibleContext().setAccessibleName("fotoPublicacion");
        btComentar.getAccessibleContext().setAccessibleName("btcomentar");
        btExaminar.getAccessibleContext().setAccessibleName("btexaminar");
        radioTexto.getAccessibleContext().setAccessibleName("radioTexto");
    }// </editor-fold>//GEN-END:initComponents

    private void btComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComentarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btComentarActionPerformed

    private void btExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExaminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExaminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComentar;
    private javax.swing.JButton btExaminar;
    private javax.swing.JLabel fotoPublicacion;
    private javax.swing.JRadioButton radioTexto;
    // End of variables declaration//GEN-END:variables
}