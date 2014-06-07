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

    private  Image imagen;
    private String titulo;

    public Foto(Image imagen, String titulo, Usuario u) {
        super( u);
        this.imagen = imagen;
        this.titulo = titulo;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void comentarPublicacion(Publicacion p, Usuario a) {
        super.comentarPublicacion(p, a); //To change body of generated methods, choose Tools | Templates.
    }


 
      @Override
    public String toString() {
        return "el comentario es: " +titulo;
    }





}
