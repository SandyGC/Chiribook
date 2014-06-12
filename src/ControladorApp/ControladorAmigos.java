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
/**
 * Constructor de la clase controlador
 * Recibe una vista para poder acceder a ella y una clase del modelo
 * par apoder consultar datos
 * @param vistaAmigos
 * @param a 
 */
    public ControladorAmigos(MisAmigos vistaAmigos, Usuario a) {
        this.vistaAmigos = vistaAmigos;
        daoAmistad = DBConfig.getInstance().getFactoria().getAmistadDAO();
        recuperarListaAmigos(a);
    }
/**
 * Recupera la lista de mis amigos
 * Consulto con el dao para qu eme devuelva todas las amistades
 * y compruebo si esta esta aprobada es mi amigo y muestro el panel correspondiente
 * @param us 
 */
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
/**
 * Metodo que transforma la imagen de bytes a ImageIcon
 * @param foto
 * @return 
 */
    public ImageIcon recibeImagen(byte[] foto) {
        if (foto==null) {
            return null;
        }else{
        ImageIcon al = new ImageIcon(foto);
        return al;
        }
    }
}
