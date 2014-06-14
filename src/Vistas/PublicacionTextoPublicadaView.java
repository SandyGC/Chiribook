/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Texto;
import Modelo.Usuario;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author SANGYG
 */
public class PublicacionTextoPublicadaView extends javax.swing.JPanel {

    Texto t;
    Usuario a;

    /**
     * Creates new form PublicacionPublicadaView
     *
     * @param t
     * @param a
     */
    public PublicacionTextoPublicadaView(Texto t, Usuario a) {
        this.t = t;
        this.a = a;
        initComponents();
    }

    /**
     * Metodo que rellena una publicacion en la vista. Le paso el objeto texto
     * para que obtenga su comentario.
     *
     * @param t
     */
    public final void rellenarpublicacionPublicada(Texto t) {
        textoPublicado.setEditable(false);
        textoPublicado.setText(t.getComentario());
        ImageIcon foto = new ImageIcon(a.getFotoPerfil());
        fotoPublicacionPublicada.setIcon(foto);
        jlFecha.setText(t.getFecha().toString());
    }

    /**
     * Metodo que esconde los paneles en los que aparece la opcion par publicar
     * y los comentarios de esa publicacion.
     */
    public void esconderPaneles() {
        panelHacerComentario.setVisible(false);
        panelHacerComentario.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPublicacionPublicada = new javax.swing.JPanel();
        fotoPublicacionPublicada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoPublicado = new javax.swing.JTextArea();
        btComentar = new javax.swing.JButton();
        meGusta = new javax.swing.JToggleButton();
        jlFecha = new javax.swing.JLabel();
        panelHacerComentario = new javax.swing.JPanel();
        panelComentarios = new javax.swing.JPanel();

        fotoPublicacionPublicada.setText("foto");

        textoPublicado.setColumns(20);
        textoPublicado.setRows(5);
        jScrollPane1.setViewportView(textoPublicado);

        btComentar.setText("Comentar");
        btComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComentarActionPerformed(evt);
            }
        });

        meGusta.setText("Me Gusta");

        jlFecha.setText("jLabel1");

        javax.swing.GroupLayout panelPublicacionPublicadaLayout = new javax.swing.GroupLayout(panelPublicacionPublicada);
        panelPublicacionPublicada.setLayout(panelPublicacionPublicadaLayout);
        panelPublicacionPublicadaLayout.setHorizontalGroup(
            panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPublicacionPublicadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoPublicacionPublicada, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jlFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btComentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meGusta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelPublicacionPublicadaLayout.setVerticalGroup(
            panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPublicacionPublicadaLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btComentar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meGusta)
                .addGap(27, 27, 27))
            .addComponent(fotoPublicacionPublicada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPublicacionPublicadaLayout.createSequentialGroup()
                .addComponent(jlFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelHacerComentarioLayout = new javax.swing.GroupLayout(panelHacerComentario);
        panelHacerComentario.setLayout(panelHacerComentarioLayout);
        panelHacerComentarioLayout.setHorizontalGroup(
            panelHacerComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelHacerComentarioLayout.setVerticalGroup(
            panelHacerComentarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelComentariosLayout = new javax.swing.GroupLayout(panelComentarios);
        panelComentarios.setLayout(panelComentariosLayout);
        panelComentariosLayout.setHorizontalGroup(
            panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelComentariosLayout.setVerticalGroup(
            panelComentariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPublicacionPublicada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHacerComentario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelPublicacionPublicada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(panelHacerComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComentarActionPerformed
        // TODO add your handling code here:
        panelHacerComentario.setVisible(true);
    }//GEN-LAST:event_btComentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComentar;
    private javax.swing.JLabel fotoPublicacionPublicada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JToggleButton meGusta;
    private javax.swing.JPanel panelComentarios;
    private javax.swing.JPanel panelHacerComentario;
    private javax.swing.JPanel panelPublicacionPublicada;
    private javax.swing.JTextArea textoPublicado;
    // End of variables declaration//GEN-END:variables
}
