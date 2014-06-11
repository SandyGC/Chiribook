/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Usuario;

/**
 *
 * @author SANGYG
 */
public interface IUsuarioDAO extends IDAO<Usuario>{
 //AQUI VAN LOS METODOS PERSONALIZADOS
    public Usuario readForName(Usuario a);
}
