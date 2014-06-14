/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.ComentarioTexto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author SandyG
 */
public class ControladorBtComentarComentario implements ActionListener {

    private JPanel panel;
    private String texto;
    private Usuario usuario;
    private Texto publiTexto;

    public ControladorBtComentarComentario(String tex, JPanel panel,Usuario u) {
        this.texto=texto;
        this.panel=panel;
        this.usuario=u;
        publiTexto= new Texto(tex,u);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ComentarioTexto comentText= new ComentarioTexto(publiTexto);
        panel.setVisible(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(comentText);
    }

}
