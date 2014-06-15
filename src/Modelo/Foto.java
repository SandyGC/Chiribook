/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author SandyG
 */
public class Foto extends Publicacion {

    private  byte[] imagen;

    public Foto(byte[] imagen, int id, Usuario u) {
        super(id, u);
        this.imagen = imagen;
    }

    public Foto(byte[] imagen, Usuario usuario) {
        super(usuario);
        this.imagen = imagen;
    }

    
    
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }


    @Override
    public void comentarPublicacion(Publicacion p, Usuario a) {
        super.comentarPublicacion(p, a); //To change body of generated methods, choose Tools | Templates.
    }

}
