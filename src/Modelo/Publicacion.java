/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SandyG
 */
public class Publicacion {

    private int id;
    private Date fecha;
    private final ArrayList<Publicacion> comentarios;
    private Usuario usuario;

    public Publicacion(Usuario u) {

        this.usuario = u;
        //fecha actual
        this.fecha = new Date();
        comentarios = new ArrayList<>();
    }

    public Publicacion() {
         this.fecha = new Date();
        this.comentarios = new ArrayList<>();
    }

    public Publicacion(int id, Date fecha,Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.comentarios = new ArrayList<>();
        this.usuario = usuario;
    }

    public ArrayList<Publicacion> getComentarios() {
        return comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que comenta una publicacion
     *
     * @param p
     * @param a
     */
    public void comentarPublicacion(Publicacion p, Usuario a) {
        if (usuario.existeAmistad(a) == true) {
            comentarios.add(p);
        } else {
            System.out.println("El usuarii no es tu amigo");
        }

    }

}
