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
import java.util.ArrayList;
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
//        Usuario dao = daoUsuario.read(a);
//        if (dao.equals(a)) {
//            System.out.println(dao.toString());
//            return dao;
//        }
       Usuario correcto= daoUsuario.read(a);
        if (correcto!=null) {
            return correcto;
        }
//       List<Usuario> us= daoUsuario.readAll();
//        for (Usuario usuario : us) {
//            System.out.println(usuario.toString());
//        }
      return null;
        
    }
}
