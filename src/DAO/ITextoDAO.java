/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Texto;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author SANGYG
 */
public interface ITextoDAO extends IDAO<Texto> {

    public void crearComentario(Usuario a,Texto t);
    public int devolverIdPublicacion(int id);
}
