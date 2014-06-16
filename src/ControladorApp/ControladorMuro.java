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
import Vistas.ComentarioFoto;
import Vistas.ComentarioTexto;
import Vistas.MiMuro;
import Vistas.PublicacionFotoPublicadaView;
import Vistas.PublicacionTextoPublicadaView;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author SandyG
 */
public final class ControladorMuro {

    private MiMuro vistaMuro;
    private Usuario usuario;
    private Texto texto, comentario;
    private Foto foto;
    private ITextoDAO textoDAO;
    private IFotoDAO fotoDAO;
    private IPublicacionDAO daoPublicacion;
    private ResourceBundle bundle;
//le paso la vista usuario la que va usuario modificar

    public ControladorMuro(MiMuro vistaMuro, Usuario a, ResourceBundle bundle) {
        textoDAO = DBConfig.getInstance().getFactoria().getTextoDAO();
        fotoDAO = DBConfig.getInstance().getFactoria().getFotoDAO();
        daoPublicacion = DBConfig.getInstance().getFactoria().getPublicacionDAO();
        this.usuario = a;
        this.vistaMuro = vistaMuro;
        this.bundle = bundle;
        rellenarMuro(a);

    }

    /**
     * Metodo que crea un publicacion de tipo texto obtenemos los datos de la
     * vista, construimos un objeto y se los pasamos al DAO
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

    /**
     * Metodo que crea una publicacion de tipo foto
     *
     * @param imagen
     * @param u
     */
    public void crearPublicacionFoto(ImageIcon imagen, Usuario u) {
        byte[] insfoto = recibeImagen(imagen);
        foto = new Foto(insfoto, u);
        u.comentarMiMuro(foto);
        fotoDAO.create(foto);
        mostrarPublicacionFoto(foto, u);

    }

    /**
     * Metodo que transforma la imagen de ImagenIcon a bytes
     *
     * @param imagen
     * @return
     */
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
     *
     * Metodo que muestra la publicacion de tipo texto en otro panel una vez
     * hecha
     *
     * @param t
     * @param u
     */
    public PublicacionTextoPublicadaView mostrarPublicacionTexto(Texto t, Usuario u) {
        PublicacionTextoPublicadaView v = new PublicacionTextoPublicadaView(t, u, this, bundle);
        //v.esconderPaneles();
        //llamo al metodo de la vista que rellenara esta vista
        v.rellenarpublicacionPublicada(t);
        vistaMuro.getPanelMuro2().add(v);
        v.setVisible(true);
        vistaMuro.updateUI();
        return v;
    }

    /**
     * Metodo que muestra una publicacion de tipo foto una vez realizada
     *
     * @param f
     * @param u
     */
    public PublicacionFotoPublicadaView mostrarPublicacionFoto(Foto f, Usuario u) {
        PublicacionFotoPublicadaView vfoto = new PublicacionFotoPublicadaView(f, u, this, bundle);
        // vfoto.esconderPaneles();
        vfoto.rellenarpublicacionPublicada(f);
        vistaMuro.getPanelMuro2().add(vfoto);
        vfoto.setVisible(true);
        vistaMuro.updateUI();
        return vfoto;
    }

    /**
     * Metodo que rellena el muro obtniendo todas las publicaciones de un
     * usuario. Comprueba si es un texto para mostrar la publicacion con el
     * panel de texto o foto para mostrar con el panel de foto.
     *
     * @param u
     */
    public void rellenarMuro(Usuario u) {
        PublicacionTextoPublicadaView textopublicada = null;
        PublicacionFotoPublicadaView fotoPublicada = null;

        List<Publicacion> publicaciones = daoPublicacion.publicacionfromUser(u);

        for (Publicacion publicacion : publicaciones) {

            if (publicacion instanceof Texto) {
                Texto texto = (Texto) publicacion;
                textopublicada = mostrarPublicacionTexto(texto, u);
                textopublicada.comentariosVisibles();
                //   recuperarComentarios(publicacion, null, textopublicada);
            }
            if (publicacion instanceof Foto) {
                Foto fo = (Foto) publicacion;
                fotoPublicada = mostrarPublicacionFoto(fo, u);
                //     recuperarComentarios(publicacion, fotoPublicada, null);
            }
            recuperarComentarios(publicacion, fotoPublicada, textopublicada);
        }

    }

    public void recuperarComentarios(Publicacion publi, PublicacionFotoPublicadaView publiPadreFoto,
            PublicacionTextoPublicadaView publiPadreTexto) {
        List<Publicacion> comentarios = daoPublicacion.comentariosDePublicacion(publi);


        for (Publicacion publicacion : comentarios) {
            if (publicacion instanceof Texto) {
                Texto texto = (Texto) publicacion;
                publi.getComentarios().add(texto);
                mostratComentarioTexto(texto, bundle, publiPadreTexto);
            }
            if (publicacion instanceof Foto) {
                Foto fo = (Foto) publicacion;
                publi.getComentarios().add(fo);
                mostrarComentarioFoto(fo, bundle, publiPadreTexto);
            }
        }


    }

    public void mostratComentarioTexto(Texto texto, ResourceBundle bundle,
            PublicacionTextoPublicadaView publiPadre) {

        ComentarioTexto comentTexto = new ComentarioTexto(texto, bundle);
        publiPadre.insertComentario(texto);

    }

    public void mostrarComentarioFoto(Foto foto, ResourceBundle bundle,
            PublicacionTextoPublicadaView publiPadre) {
        ComentarioFoto comentFoto = new ComentarioFoto(foto);
        publiPadre.inserComentarioFoto(foto);
    }

    public Usuario getA() {
        return usuario;
    }

    public Texto getT() {
        return texto;
    }
}
