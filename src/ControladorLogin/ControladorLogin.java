/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorLogin;

import DAO.DBConfig;
import DAO.HSQL.HSQLUsuarioDAO;
import DAO.IUsuarioDAO;
import DAO.UtilConnectionHSQL;
import Modelo.Usuario;
import VistaLoginApp.Login;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SandyG
 */
public class ControladorLogin {

    Login l;
    IUsuarioDAO daoUsuario;

    public ControladorLogin(Login l) {
        this.l = l;
        daoUsuario = DBConfig.getInstance().getFactoria().getUsuarioDAO();
    }

    public Usuario buscarUsuario() {

        String nombre = l.getJtNombre().getText();
        String pass = new String(l.getJtPass().getPassword());
        Usuario a = new Usuario(nombre, pass);

       Usuario correcto= daoUsuario.read(a);
        if (correcto!=null) {
            return correcto;
        }

      return null;
        
    }
}
