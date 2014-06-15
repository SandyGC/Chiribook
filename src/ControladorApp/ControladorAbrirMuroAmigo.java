/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorApp;

import Modelo.Usuario;
import Vistas.MiMuro;
import Vistas.MuroAmigo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

/**
 *
 * @author $Sandy.G
 */
public class ControladorAbrirMuroAmigo extends MouseAdapter{

    private Usuario usuario;
    private ResourceBundle bundle;
    
    public ControladorAbrirMuroAmigo(Usuario usuario, ResourceBundle bundle) {
        this.usuario=usuario;
        this.bundle=bundle;
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        MiMuro muroAmigo = new MiMuro(usuario, bundle);
      MuroAmigo JFramemuroAmigo =new MuroAmigo(muroAmigo);
      JFramemuroAmigo.setVisible(true);
    }

    
    
}
