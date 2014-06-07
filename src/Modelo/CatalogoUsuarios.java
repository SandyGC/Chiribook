/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.DBConfig;
import DAO.IUsuarioDAO;
import java.util.List;



/**
 *
 * @author SandyG
 */
public class CatalogoUsuarios {

    private IUsuarioDAO daoUsuarios= DBConfig.getInstance().getFactoria().getUsuarioDAO();
    
    public List<Usuario> getUsuarios(){
    
    return daoUsuarios.readAll();
    
    }
    
    
    /**
     * Metodo para buscar un usuario en todo el arraylist de usuarios.
     *
     * @param a
     * @return
     */
//    public Usuario buscarUsuario(Usuario a) {
//        Usuario us = null;
//        for (Usuario usuario : usuarios) {
//            if (usuario.equals(a)) {
//                us = usuario;
//            }
//        }
//        return us;
//    }
}
