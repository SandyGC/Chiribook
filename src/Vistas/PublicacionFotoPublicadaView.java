/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import ControladorApp.ControladorBtComentarComentario;
import ControladorApp.ControladorMuro;
import ControladorApp.ControladorRadioButtonMuro;
import Modelo.Foto;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.CardLayout;
import java.awt.Image;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author SANGYG
 */
public class PublicacionFotoPublicadaView extends javax.swing.JPanel {

    private Foto foto;
    private Usuario usuario;
    private ControladorMuro controladorMuro;
    private ResourceBundle bundle;
    private JButton comentarComent;
   ControladorBtComentarComentario cbtComentarioFoto;

    /**
     * Creates new form PublicacionPublicadaView
     *
     * @param foto
     * @param a
     */
    public PublicacionFotoPublicadaView(Foto foto, Usuario a, ControladorMuro c, ResourceBundle bundle) {
        this.controladorMuro = c;
        this.foto = foto;
        this.bundle = bundle;
        this.usuario = a;
        initComponents();
    }

    public final void rellenarpublicacionPublicada(Foto f) {

        Image i = ImageConverter.bytes2Image(f.getImagen());
        if (i != null) {
            fotoPublicada.setText("");
            fotoPublicada.setIcon(new ImageIcon(i));
            fotoPerfil.setIcon(new ImageIcon(usuario.getFotoPerfil()));
            labelFecha.setText(f.getFecha().toString());
            jlNombre.setText(usuario.getNombreCompleto());
        } else {

            fotoPublicada.setText("No Image");
            fotoPublicada.setIcon(null);
        }

    }

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
        fotoPerfil = new javax.swing.JLabel();
        btComentar = new javax.swing.JButton();
        meGusta = new javax.swing.JToggleButton();
        labelFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fotoPublicada = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        panelHacerComentario = new javax.swing.JPanel();
        panelComentarios = new javax.swing.JPanel();

        fotoPerfil.setText("jLabel1");

        btComentar.setText("Comentar");
        btComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComentarActionPerformed(evt);
            }
        });

        meGusta.setText("Me Gusta");
        meGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meGustaActionPerformed(evt);
            }
        });

        labelFecha.setText("jLabel1");

        fotoPublicada.setText("jLabel2");
        jScrollPane1.setViewportView(fotoPublicada);

        jlNombre.setText("jLabel1");

        javax.swing.GroupLayout panelPublicacionPublicadaLayout = new javax.swing.GroupLayout(panelPublicacionPublicada);
        panelPublicacionPublicada.setLayout(panelPublicacionPublicadaLayout);
        panelPublicacionPublicadaLayout.setHorizontalGroup(
            panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPublicacionPublicadaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(fotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(meGusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btComentar, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPublicacionPublicadaLayout.setVerticalGroup(
            panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelPublicacionPublicadaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btComentar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meGusta)
                .addGap(80, 80, 80))
            .addGroup(panelPublicacionPublicadaLayout.createSequentialGroup()
                .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPublicacionPublicadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(fotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(panelPublicacionPublicada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelHacerComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void meGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meGustaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meGustaActionPerformed

    private void btComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComentarActionPerformed
//                // TODO add your handling code here:
//  panelHacerComentario.setVisible(true);
//        //al panel le hago el cardLayout
//        panelHacerComentario.setLayout(new CardLayout());
//        //me creo el panel que añado que es de texto
//        PublicacionTextoView publicacionTexto = new PublicacionTextoView(controladorMuro, usuario, bundle);
//        publicacionTexto.desactivarActivarComentar();
//        //añado el card
//        panelHacerComentario.add(publicacionTexto, "texto");
//        //me creo el otro panel que añado al card
//        PublicacionFotoView publicacionFoto = new PublicacionFotoView(controladorMuro, usuario, bundle);
//        publicacionFoto.desactivarActivarComentar();
//        //añado el panel foto al card
//        panelHacerComentario.add(publicacionFoto, "foto");
//
//        //recupero el boton comentarComentario de la publicacion texto
//        //this = publicacionFoto.getBtComentarComentario();
//        
//        this.comentarComentFoto = publicacionFoto.getBtComentarComentario();
//        //eventos usuario los que responde el radiobutton
//        ControladorRadioButtonMuro cbutton = new ControladorRadioButtonMuro(null, bundle, panelHacerComentario);
//        //obtengo los dos radio buttons de los paneles distinttos para añadirles el action listener
//        publicacionTexto.getRadioFoto().addActionListener(cbutton);
//        publicacionFoto.getRadioTexto().addActionListener(cbutton);
//
//        //instancio el controlador que se encargara de la publicacion que le paso añadirlo al panel de comentarios
//        cbtComentarTexto = new ControladorBtComentarComentario(foto, publicacionTexto, panelComentarios, usuario, bundle);
//
//        cbtComentarioFoto = new ControladorBtComentarComentario(foto, publicacionFoto, panelComentarios, usuario, bundle);
//        //le añado el actionListener
//        comentarComentTexto.addActionListener(cbtComentarTexto);
//        comentarComentFoto.addActionListener(cbtComentarioFoto);
    }//GEN-LAST:event_btComentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComentar;
    private javax.swing.JLabel fotoPerfil;
    private javax.swing.JLabel fotoPublicada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JToggleButton meGusta;
    private javax.swing.JPanel panelComentarios;
    private javax.swing.JPanel panelHacerComentario;
    private javax.swing.JPanel panelPublicacionPublicada;
    // End of variables declaration//GEN-END:variables
}
