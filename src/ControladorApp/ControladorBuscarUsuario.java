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

/**
 *
 * @author SandyG
 */
public class ControladorBuscarUsuario {
 BuscarUsuarios vistaBuscar;
    IUsuarioDAO daoUsuario;

    public ControladorBuscarUsuario(BuscarUsuarios buscarU) {
       this.vistaBuscar=buscarU;
        daoUsuario = DBConfig.getInstance().getFactoria().getUsuarioDAO();
    }

    public Usuario buscarUsuario() {

        String nombre = vistaBuscar.getjTNombre().getText();
        Usuario a = new Usuario(nombre);

       Usuario correcto= daoUsuario.read(a);
        if (correcto!=null) {
            return correcto;
        }

      return null;
        
    }
}
