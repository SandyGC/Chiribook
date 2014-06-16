/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IFotoDAO;
import DAO.ITextoDAO;
import Modelo.Foto;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.ComentarioFoto;
import Vistas.ComentarioTexto;
import Vistas.PublicacionFotoView;
import Vistas.PublicacionTextoView;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author SandyG
 */
public class ControladorBtComentarComentario implements ActionListener {

    private JPanel panelAdd;
    private JPanel panelComentarios;
    private ITextoDAO daoTexto;
    private IFotoDAO daoFoto;
    private Usuario usuario;
    private Texto publiTexto, publicacionDueña;
    private Foto publiFoto, publicacionDueñaFoto;
    private ResourceBundle bundle;

    public ControladorBtComentarComentario(Texto publicacionDueña, JPanel panelComentarios, JPanel panelAdd, Usuario u,ResourceBundle bundle) {
        this.daoTexto = DBConfig.getInstance().getFactoria().getTextoDAO();
        this.daoFoto = DBConfig.getInstance().getFactoria().getFotoDAO();
        this.panelAdd = panelAdd;
        this.panelComentarios = panelComentarios;
        this.usuario = u;
        this.publicacionDueña = publicacionDueña;
        this.bundle=bundle;
    }

    public ControladorBtComentarComentario(Foto publicacionDueña,JPanel panelAdd, JPanel panelComentarios, Usuario usuario, ResourceBundle bundle) {
        this.daoTexto = DBConfig.getInstance().getFactoria().getTextoDAO();
        this.daoFoto = DBConfig.getInstance().getFactoria().getFotoDAO();
        this.panelAdd = panelAdd;
        this.panelComentarios = panelComentarios;
        this.publicacionDueñaFoto = publicacionDueña;
        this.usuario = usuario;
        this.bundle = bundle;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panelComentarios instanceof PublicacionTextoView) {

            PublicacionTextoView publitex = (PublicacionTextoView) panelComentarios;
            publiTexto = new Texto(publitex.getTexto().getText(), usuario);
            publicacionDueña.comentarPublicacion(publiTexto, usuario);
            daoTexto.crearComentario(publicacionDueña, publiTexto);
            ComentarioTexto comentText = new ComentarioTexto(publiTexto,bundle);
            panelAdd.setVisible(true);
            panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
            panelAdd.add(comentText);
            publitex.getTexto().setText("");
        } else {

            try {
                PublicacionFotoView publiFoto = (PublicacionFotoView) panelComentarios;
                byte[] foto = ImageConverter.image2Bytes(publiFoto.getIcon().getImage());
                Foto publicacionFoto = new Foto(foto, usuario);
                publicacionDueña.comentarPublicacion(publicacionFoto, usuario);
                daoFoto.create(publicacionFoto);
                ComentarioFoto comentFoto = new ComentarioFoto(publicacionFoto);
                panelAdd.setVisible(true);
                panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));
                panelAdd.add(comentFoto);
            } catch (IOException ex) {
                Logger.getLogger(ControladorBtComentarComentario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
