/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IAmistadDAO;
import Modelo.Amistad;
import Modelo.Usuario;
import Vistas.MisAmigos;
import Vistas.PanelAmigo;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author SandyG
 */
public class ControladorAmigos {

    MisAmigos vistaAmigos;
    IAmistadDAO daoAmistad;
    Usuario a;

    public ControladorAmigos(MisAmigos vistaAmigos, Usuario a) {
        this.vistaAmigos = vistaAmigos;
        daoAmistad = DBConfig.getInstance().getFactoria().getAmistadDAO();
        recuperarListaAmigos(a);
    }

    public final void recuperarListaAmigos(Usuario us) {
        List<Amistad> amigos = daoAmistad.devolverAmigos(us);
        for (Amistad amistad : amigos) {
            if (amistad.isAprobada()) {
                PanelAmigo panel = new PanelAmigo();
                ImageIcon foto = recibeImagen(amistad.getAmigo().getFotoPerfil());
                if (foto == null) {
                    panel.getjLFoto().setText("No image");
                } else {
                    panel.cargarFoto(foto);

                }
                panel.getjLNombre().setText(amistad.getAmigo().getNombreCompleto());
                panel.setVisible(true);
                vistaAmigos.getjPanelAmigos().add(panel);
            }
        }
    }

    public ImageIcon recibeImagen(byte[] foto) {
        if (foto==null) {
            return null;
        }else{
        ImageIcon al = new ImageIcon(foto);
        return al;
        }
    }
}
