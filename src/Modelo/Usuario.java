/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author SandyG
 */
public class Usuario {

    private String nombreCompleto, email;
    private int edad, id;
    private String contraseña;
    private byte[] fotoPerfil;
    // aqui voy a tener las amistades de mis usuarios
    private ArrayList<Amistad> amigos;
    //muro del usuario
    private Muro muroUsuario;
    //GUSTOS DE USUARIO
    private final ArrayList<Publicacion> gustos;

    public Usuario(int id, String nombreCompleto, String email, int edad, String contraseña, byte[] fotoPerfil) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.edad = edad;
        this.contraseña = contraseña;
        this.fotoPerfil = fotoPerfil;
        this.amigos = new ArrayList<>();
        this.muroUsuario = new Muro(this);
        this.gustos = new ArrayList<>();
    }

    public Usuario(String nombreCompleto, String contraseña) {
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
        this.amigos = new ArrayList<>();
        this.muroUsuario = new Muro(this);
        this.gustos = new ArrayList<>();
    }

    public Usuario() {
        this.amigos = new ArrayList<>();
        this.muroUsuario = new Muro(this);
        this.gustos = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //obtener la contraseña
    public String getContraseña() {
        return contraseña;
    }

    //editar la contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //obtener la foto de perfil
    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    //editar foto de perfil
    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    //obtener todos los amigos de mi usuario
    public ArrayList<Amistad> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Amistad> amigos) {
        this.amigos = amigos;
    }

    public Muro getMuroUsuario() {
        return muroUsuario;
    }

    public ArrayList<Publicacion> getGustos() {
        return gustos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que añade la amistad de un usuario con otro a sus respectivas
     * listas de amistad.
     *
     * @param a
     */
    public void addAmistad(Usuario a) {
        Amistad nuevaAmistad = new Amistad(a,false,null);
        amigos.add(nuevaAmistad);
        a.getAmigos().add(new Amistad(this,false,null));
        //apruebo la amistad en mi lista de amigos
        this.aprobarAmistdad(nuevaAmistad);

    }

    public void aprobarAmistdad(Amistad a) {

        a.setAprobada(true);
    }

    public Amistad getAmistad(Usuario a) {
        Amistad amis = null;
        ArrayList<Amistad> amigosA = this.getAmigos();
        for (Amistad amistad : amigosA) {
            if (amistad.getAmigo().equals(a)) {
                amis = amistad;
            }
        }

        return amis;
    }

    /**
     * Metodo al que le paso un usuario para comprobar si existe la amistad
     * entre el usuario actual y el que le paso.
     *
     * @param a
     * @return
     */
    public boolean existeAmistad(Usuario a) {
        boolean existeAmistad = false;
        ArrayList<Amistad> amigosA = this.getAmigos();
        for (Amistad amistad : amigosA) {
            if (this.equals(a)) {
                existeAmistad = true;
            }
            if (amistad.getAmigo().equals(a)) {
                if (amistad.isAprobada()) {
                    existeAmistad = true;
                }
            }
        }
        return existeAmistad;
    }

    /**
     * Metodo al que le paso una publicacion y la añado a mi lista de gustos
     *
     * @param p
     * @param a
     */
    public void gustosUsuario(Publicacion p, Usuario a) {
        if (existeAmistad(a) == true) {
            gustos.add(p);
        }

    }

    /**
     * Comenat en el muro de un amigo Para ello primero compruebo la amistad y
     * si esta existe llamo al metodo comentar de la clase publicacion, obtengo
     * el muro del usuario y añado la publicacion diciedole que yo(this) he
     * comentado
     *
     * @param c
     * @param a
     */
    public void comentarMiMuro(Publicacion c) {
     muroUsuario.addPublicacion(c);
    }

    @Override
    public boolean equals(Object obj) {
        Usuario u = (Usuario) obj;
        if (this.id == u.getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + " ID= " + id + ", nombreCompleto= " + nombreCompleto + ", email= " + email + ", edad= " + edad + ", contrase\u00f1a= " + contraseña + ", fotoPerfil=" + fotoPerfil + ", amigos=" + amigos + ", muroUsuario=" + muroUsuario + ", gustos=" + gustos + '}';
    }

}
