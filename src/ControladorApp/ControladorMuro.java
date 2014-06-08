/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.HSQL.HSQLPublicacionDAO;
import DAO.HSQL.HSQLTextoDAO;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.MiMuro;
import Vistas.PublicacionTextoPublicadaView;
import Vistas.VistaPrincipal;
import java.util.List;

/**
 *
 * @author SandyG
 */
public final class ControladorMuro {

    private MiMuro vistaMuro;
    private Usuario a;
    private Texto t;
    private HSQLTextoDAO textoDAO;
    private HSQLPublicacionDAO daoPublicacion;
    private Texto comentarioTexto;
//le paso la vista a la que va a modificar

    public ControladorMuro(MiMuro vistaMuro, Usuario a) {
        textoDAO = new HSQLTextoDAO();
        daoPublicacion= new HSQLPublicacionDAO();
        this.a = a;
        this.vistaMuro = vistaMuro;
        rellenarMuro(a);

    }

    /**
     * Crea la publicacion y llama al metodo mostrarPublicacion para mostrarla
     *
     * @param m
     * @param a
     */
    public void crearPublicacion(String m, Usuario a) {
        t = new Texto(m, a);
        a.comentarMiMuro(t);
        textoDAO.create(t);
        comentarioTexto = new Texto(m, a);
        mostrarPublicacion();
    }

    /**
     * Metodo que crea una vista de publicacion cada vez que le de al boton
     * comentar, crerara un panel de tipo Publicacion Publicada
     */
    public void mostrarPublicacion() {

        PublicacionTextoPublicadaView v = new PublicacionTextoPublicadaView(t, a);
        v.esconderPaneles();
        //llamo al metodo de la vista que rellenara esta vista
        v.rellenarpublicacionPublicada();
  
        vistaMuro.getPanelMuro2().add(v);
        v.setVisible(true);
        vistaMuro.updateUI();
        
    }
    
    public void rellenarMuro(Usuario a){
    List<Publicacion> comentarios=daoPublicacion.publicacionfromUser(a);
        for (Publicacion publicacion : comentarios) {
            if (publicacion instanceof Texto) {
                System.out.println(publicacion.toString());
                
            }else{
                System.out.println("  fddd");
            }
        }
    }

    public void publicarPublicacion(Texto t) {

    }

    public Usuario getA() {
        return a;
    }

    public Texto getT() {
        return t;
    }

}
