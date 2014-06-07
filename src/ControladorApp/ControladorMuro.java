/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.HSQL.HSQLPublicacionDAO;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.MiMuro;
import Vistas.VistaPrincipal;

/**
 *
 * @author SandyG
 */
public class ControladorMuro {

    private MiMuro vistaMuro;
    private Usuario a;
    private Publicacion p;
    private HSQLPublicacionDAO daoPublicacion;
//le paso la vista a la que va a modificar

    public ControladorMuro(MiMuro vistaMuro, Usuario a) {
        daoPublicacion = new HSQLPublicacionDAO();
        this.a = a;
        this.vistaMuro = vistaMuro;
    }
    
    public void crearPublicacion(String m, Usuario a) {
        p = new Texto(m, a);
        a.comentarMiMuro(p);
        System.out.println(p.toString());
        daoPublicacion.create(p);
    }
    public void ejemplo(){
    
    }

}
