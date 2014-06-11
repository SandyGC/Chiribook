/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IUsuarioDAO;
import Modelo.Usuario;
import VistaLoginApp.Login;
import Vistas.BuscarUsuarios;
import Vistas.PanelUsuario;
import java.util.List;

/**
 *
 * @author SandyG
 */
public class ControladorBuscarUsuario {

    BuscarUsuarios vistaBuscar;
    IUsuarioDAO daoUsuario;

    public ControladorBuscarUsuario(BuscarUsuarios buscarU) {
        this.vistaBuscar = buscarU;
        daoUsuario = DBConfig.getInstance().getFactoria().getUsuarioDAO();
    
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
        for (Usuario usuario : usuarios) {
            PanelUsuario panelU = new PanelUsuario(usuario);
            panelU.setVisible(true);
            vistaBuscar.getjPanelUsuario().setVisible(false);
            vistaBuscar.getjPanelUsuarios().add(panelU);
            
        }
    }
}
