/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SandyG
 */
public class Amistad {

    private Usuario amigo;
    private boolean aprobada=false;
private String tipo;

    public Amistad(Usuario amigo, boolean aprobada, String tipo) {
        this.amigo = amigo;
        this.aprobada = aprobada;
        this.tipo = tipo;
    }

 
    
    public void aceptarAmistad(){
            aprobada=true;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public Usuario getAmigo() {
        return amigo;
    }

    @Override
    public String toString() {
        return "Amistad{" + "amigo=" + amigo.getNombreCompleto() + ", aprobada=" + aprobada + ", tipo=" + tipo + '}';
    }



}
