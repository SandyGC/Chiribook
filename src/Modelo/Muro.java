/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author SandyG
 */
/**
 * Em esta clase no he sabido relacionar el muro con las publicaciones, no se si
 * deberia haber una lista de publicaciones.
 */
public class Muro {

    private final ArrayList<Publicacion> publicaciones;
    private Usuario usuario;

    public Muro(Usuario usuario) {
        this.usuario = usuario;
        this.publicaciones = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    //metodo que comenta mi muro
    public void addPublicacion(Publicacion p){
    publicaciones.add(p);
    }

}
