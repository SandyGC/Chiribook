/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IPublicacionDAO;
import DAO.ITextoDAO;
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
    private ITextoDAO textoDAO;
    private IPublicacionDAO daoPublicacion;
    private Texto comentarioTexto;
//le paso la vista a la que va a modificar

    public ControladorMuro(MiMuro vistaMuro, Usuario a) {
        textoDAO =  DBConfig.getInstance().getFactoria().getITextoDAO();
        daoPublicacion= DBConfig.getInstance().getFactoria().getPublicacionDAO();
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
        mostrarPublicacion(t,a);
    }

    /**
     * Metodo que crea una vista de publicacion cada vez que le de al boton
     * comentar, crerara un panel de tipo Publicacion Publicada
     * @param tex
     * @param aa
     */
    public void mostrarPublicacion(Texto tex, Usuario aa) {

        PublicacionTextoPublicadaView v = new PublicacionTextoPublicadaView(tex, aa);
        v.esconderPaneles();
        //llamo al metodo de la vista que rellenara esta vista
        v.rellenarpublicacionPublicada(tex,aa);
  
        vistaMuro.getPanelMuro2().add(v);
        v.setVisible(true);
        vistaMuro.updateUI();
        
    }
   
    
    public void rellenarMuro(Usuario as){
    List<Publicacion> comentarios=daoPublicacion.publicacionfromUser(a);
        for (Publicacion publicacion : comentarios) {
            if (publicacion instanceof Texto) {
                Texto te = (Texto) publicacion;
                
                mostrarPublicacion(te, as);
                 
                
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
