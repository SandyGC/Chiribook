/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author SandyG
 */
public class Texto extends Publicacion {

    private final String comentario;

    public Texto(String comentario, int id, Usuario u) {
        super(id, u);
        this.comentario = comentario;
    }

    public Texto(String comentario, Usuario usuario) {
        super(usuario);
        this.comentario = comentario;
    }

    public Texto(String comentario, int id, Date fecha, Usuario usuario) {
        super(id, fecha, usuario);
        this.comentario = comentario;
    }
    
    
    public String getComentario() {
        return comentario;
    }

    @Override
    public void comentarPublicacion(Publicacion p, Usuario a) {
        super.comentarPublicacion(p, a); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @Override
//    public String toString() {
//        return "el comentario es: " + comentario+ " del usuario: "+super.getUsuario().getNombreCompleto();
//    }
    @Override
    public String toString() {
        return super.toString()+"Texto{" + "comentario=" + comentario + '}';
    }
   
   
    

    
    
}
