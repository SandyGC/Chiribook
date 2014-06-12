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

    public ControladorBuscarUsuario(BuscarUsuarios buscarU, Usuario u) {
        this.usuario = u;
        this.vistaBuscar = buscarU;
        daoUsuario = DBConfig.getInstance().getFactoria().getUsuarioDAO();
        rellenarUsuarios();
    }

    public Usuario buscarUsuario() {
        String nombre = vistaBuscar.getjTNombre().getText();
        Usuario a = new Usuario(nombre);
        System.out.println(nombre);
        Usuario usuarioCorrecto = daoUsuario.readForName(a);
        if (usuarioCorrecto != null) {
            return usuarioCorrecto;
        }
        return null;
    }

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
