/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IUsuarioDAO;
import Modelo.Usuario;
import Vistas.BuscarUsuarios;
import Vistas.PanelUsuario;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author SandyG
 */
public class ControladorBuscarUsuario {

    BuscarUsuarios vistaBuscar;
    IUsuarioDAO daoUsuario;
    Usuario usuario;
/**
 * Constructor de la clase
 * Recibe una vista para poder modificarla y una clase del modelo
 * para poder consultarlo
 * @param buscarU
 * @param u 
 */
    public ControladorBuscarUsuario(BuscarUsuarios buscarU, Usuario u) {
        this.usuario = u;
        this.vistaBuscar = buscarU;
        daoUsuario = DBConfig.getInstance().getFactoria().getUsuarioDAO();
        rellenarUsuarios();
    }
/**
 * Metodo que busca un usuario obteniendo el nombre de la vista,
 * construyendo un objeto y pasandoselo al DAO
 * @return 
 */
    public Usuario buscarUsuario() {
        String nombre = vistaBuscar.getjTNombre().getText();
        Usuario a = new Usuario(nombre);
        Usuario usuarioCorrecto = daoUsuario.readForName(a);
        if (usuarioCorrecto != null) {
            return usuarioCorrecto;
        }
        return null;
    }
/**
 * Metodo que rellena la lista de usuarios y muestra todos los usuarios
 * de la base de datos menos el mio, para que asi no me salga como añadir amigos
 */
    public final void rellenarUsuarios() {
        List<Usuario> usuarios = daoUsuario.readAll();
        ListIterator iter = usuarios.listIterator();
        do {
            Usuario a = (Usuario) iter.next();
            if (a.getNombreCompleto().equals(usuario.getNombreCompleto())) {
                iter.remove();
            } else {
                PanelUsuario panelU = new PanelUsuario(a);
                panelU.setVisible(true);
                vistaBuscar.getjPanelUsuarios().add(panelU);
            }
        } while (iter.hasNext());
    }
/**
 * Metodo que rellenar el panel de un amigo, obteniendo
 * los datos del modelo
 * @param a 
 */
    public void rellenarUsuario(Usuario a) {
        vistaBuscar.getjPanelUsuario().removeAll();
        if (a.getNombreCompleto().equals(usuario.getNombreCompleto())) {
            vistaBuscar.getjPanelUsuario().removeAll();
            PanelUsuario pan = new PanelUsuario(a);
            pan.setVisible(true);
            vistaBuscar.getjPanelUsuario().setVisible(true);
            vistaBuscar.getjPanelUsuario().add(pan);
            pan.getBtAñadirAmigo().setEnabled(false);
            pan.getBtVisitarPerfil().setEnabled(false);
            pan.updateUI();
        } else {
            vistaBuscar.getjPanelUsuario().removeAll();
            PanelUsuario pa = new PanelUsuario(a);
            pa.setVisible(true);
            vistaBuscar.getjPanelUsuario().setVisible(true);
            vistaBuscar.getjPanelUsuario().add(pa);
            pa.updateUI();
        }
    }

}
