/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IUsuarioDAO;
import Modelo.Usuario;
import Vistas.MiPerfil;

/**
 *
 * @author SandyG
 */
public class ControladorPerfil {

    MiPerfil vistaMiPerfil;
    Usuario a;
    IUsuarioDAO daoUsuario;

    public ControladorPerfil(MiPerfil vistaMiPerfil, Usuario a) {
        this.vistaMiPerfil = vistaMiPerfil;
        this.a = a;
        daoUsuario= DBConfig.getInstance().getFactoria().getUsuarioDAO();
    }
    
    public void recibirActualizacion(String email, int edad){
        a.setEmail(email);
        a.setEdad(edad);
        daoUsuario.update(a);
        System.out.println(a.toString());
    }
}
