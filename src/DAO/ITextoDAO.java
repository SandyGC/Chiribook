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
//metodo que crea comentario pasandole un usuario y la publicacion
    public void crearComentario(Texto publicacionDueña,Texto publicacion );
    //metodo que me devuelve el id de la publicacion
    public int devolverIdPublicacion(int id);
}
