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

    private enum tipoAmistad {

        familiar, amigo, compañero, otro
    };
    private tipoAmistad tipo;

    public Amistad(Usuario amigo) {
        this.amigo = amigo;
        tipo= tipoAmistad.otro;
    }
    public void aceptarAmistad(){
            aprobada=true;
    }

    public tipoAmistad getTipo() {
        return tipo;
    }

    public void setTipo(tipoAmistad tipo) {
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

    // para devolver el tipo de amistad 
    public String tipoAmistad(tipoAmistad tipo) {
        String relacion;
        if (tipo.equals(tipoAmistad.amigo)) {

            relacion = "Amigo";
        } else if (tipo.equals(tipoAmistad.compañero)) {
            relacion = "Compañero";
        } else {
            relacion = "Familiar";
        }
        return relacion;
    }

}
