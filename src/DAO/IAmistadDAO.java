/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Amistad;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author SANGYG
 */
public interface IAmistadDAO extends IDAO<Amistad>{
    //Metodo que devuelve una lista de amistad de un usuario
    public List<Amistad> devolverAmigos(Usuario u);
}
