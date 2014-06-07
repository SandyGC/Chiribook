/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorLogin;

import DAO.HSQL.HSQLUsuarioDAO;
import DAO.UtilConnectionHSQL;
import Modelo.Usuario;
import VistaLoginApp.Login;
import java.util.List;

/**
 *
 * @author SandyG
 */
public class ControladorLogin {

    Login l;
    HSQLUsuarioDAO daoUsuario;

    public ControladorLogin(Login l) {
        this.l = l;
        daoUsuario = new HSQLUsuarioDAO();
    }

    public Usuario buscarUsuario() {

        String nombre = l.getJtNombre().getText();
        String pass = new String(l.getJtPass().getPassword());
        Usuario a = new Usuario(nombre, pass);
        if (daoUsuario.read(a)!=null) {
            return a;
        }
        return null;
    }
}
