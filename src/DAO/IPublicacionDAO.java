/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Publicacion;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author SANGYG
 */
public interface IPublicacionDAO extends IDAO<Publicacion> {
    //Metodo que devuelve una lista de piblicaciones d eun usuario pasandole el objeto usuario

    public List<Publicacion> publicacionfromUser(Usuario a);
//metodo que realiza la accion de dar me gusta a una publicacion,
    //le paso el usuario que realiza la accion y la publicacion que le gusta
    public void guardarGustos(Usuario usuarioAccion,Publicacion p);
    //metodo para recuperar los gustos de un usuario
    public List<Publicacion> gustosDeUsuario(Usuario us);
    //metodo que lee los comentarios de una publicacion
    public List<Publicacion> comentariosDePublicacion(Publicacion p);
}
