/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Modelo.Foto;
import Modelo.Texto;

/**
 *
 * @author SANGYG
 */
public interface IFotoDAO extends IDAO<Foto>{
    public void crearComentario(Texto publicacionDueña, Foto publicacion);
}
