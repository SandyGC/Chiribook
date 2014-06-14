/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import Modelo.Texto;
import Modelo.Usuario;
import Vistas.ComentarioTexto;
import Vistas.PublicacionTextoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author SandyG
 */
public class ControladorBtComentarComentario implements ActionListener {

    private JPanel panelAdd;
   private PublicacionTextoView panelComent;
    private JTextArea text;
//    private String texto;
    private Usuario usuario;
    private Texto publiTexto;
    

    public ControladorBtComentarComentario(PublicacionTextoView panelComent, JPanel panelAdd,Usuario u) {
        this.panelAdd=panelAdd;
       this.panelComent=panelComent;
        this.usuario=u;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       publiTexto= new Texto(panelComent.getTexto().getText(),usuario);
        
        ComentarioTexto comentText= new ComentarioTexto(publiTexto);
        panelAdd.setVisible(true);
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
        panelAdd.add(comentText);
    }

}
