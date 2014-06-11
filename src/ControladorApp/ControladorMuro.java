/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IFotoDAO;
import DAO.IPublicacionDAO;
import DAO.ITextoDAO;
import Modelo.Foto;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.MiMuro;
import Vistas.PublicacionFotoPublicadaView;
import Vistas.PublicacionTextoPublicadaView;
import Vistas.VistaPrincipal;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author SandyG
 */
public final class ControladorMuro {

    private MiMuro vistaMuro;
    private Usuario usuario;
    private Texto texto;
    private Foto foto;
    private ITextoDAO textoDAO;
    private IFotoDAO fotoDAO;
    private IPublicacionDAO daoPublicacion;
//le paso la vista usuario la que va usuario modificar

    public ControladorMuro(MiMuro vistaMuro, Usuario a) {
        textoDAO = DBConfig.getInstance().getFactoria().getTextoDAO();
        fotoDAO = DBConfig.getInstance().getFactoria().getFotoDAO();
        daoPublicacion = DBConfig.getInstance().getFactoria().getPublicacionDAO();
        this.usuario = a;
        this.vistaMuro = vistaMuro;
        rellenarMuro(a);

    }

    /**
     * Crea la publicacion y llama al metodo mostrarPublicacionTexto para
     * mostrarla
     *
     * @param mensaje
     * @param u
     */
    public void crearPublicacionTexto(String mensaje, Usuario u) {
        texto = new Texto(mensaje, u);
        u.comentarMiMuro(texto);
        textoDAO.create(texto);
        mostrarPublicacionTexto(texto, u);
    }

    public void crearPublicacionFoto(ImageIcon imagen, Usuario u) {
        byte[] insfoto = recibeImagen(imagen);
        foto = new Foto(insfoto, u);
        u.comentarMiMuro(foto);
        fotoDAO.create(foto);
        mostrarPublicacionFoto(foto, u);
        
    }

    public byte[] recibeImagen(ImageIcon imagen) {
        byte[] fot = null;
        try {
            Image m = imagen.getImage();
            fot = ImageConverter.image2Bytes(m);

        } catch (IOException ex) {
            Logger.getLogger(ControladorMuro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fot;
    }

    /**
     * Metodo que crea una vista de publicacion cada vez que le de al boton
     * comentar, crerara un panel de tipo Publicacion Publicada
     *
     * @param t
     * @param u
     */
    public void mostrarPublicacionTexto(Texto t, Usuario u) {
        PublicacionTextoPublicadaView v = new PublicacionTextoPublicadaView(t, u);
        v.esconderPaneles();
        //llamo al metodo de la vista que rellenara esta vista
        v.rellenarpublicacionPublicada(t);
        vistaMuro.getPanelMuro2().add(v);
        v.setVisible(true);
        vistaMuro.updateUI();
    }

    public void mostrarPublicacionFoto(Foto f, Usuario u) {
        PublicacionFotoPublicadaView vfoto = new PublicacionFotoPublicadaView(f, u);
        vfoto.esconderPaneles();
        vfoto.rellenarpublicacionPublicada(f);
        vistaMuro.getPanelMuro2().add(vfoto);
        vfoto.setVisible(true);
        vistaMuro.updateUI();

    }

    /**
     * Metodo que rellena el muro obtniendo todas las publicaciones de un
     * usuario. Comprueba si es un texto para mostrar la publicacion con el
     * panel de texto o foto para mostrar con el panel de foto.
     *
     * @param u
     */
    public void rellenarMuro(Usuario u) {
        List<Publicacion> comentarios = daoPublicacion.publicacionfromUser(u);
        for (Publicacion publicacion : comentarios) {
            if (publicacion instanceof Texto) {
                Texto te = (Texto) publicacion;
                mostrarPublicacionTexto(te, u);
            }
            if (publicacion instanceof Foto) {
                Foto fo = (Foto) publicacion;
                mostrarPublicacionFoto(fo, u);
            }
        }
    }

    public Usuario getA() {
        return usuario;
    }

    public Texto getT() {
        return texto;
    }

}
