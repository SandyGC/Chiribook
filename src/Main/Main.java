/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.Amistad;
import Modelo.Muro;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import VistaInicioSesionBD.VistaInicio;
import Vistas.VistaPrincipal;
import java.util.ArrayList;

/**
 *
 * @author SandyG
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VistaInicio V = new VistaInicio();
                
            }
        });

//        Usuario pepe = new Usuario("Pepe", "pepeu", "adad", 12, "ddd", null);
//        Usuario juan = new Usuario("Juan", "Juanu", "adad", 12, "ddd", null);
//        Usuario paco = new Usuario("paco", "Juanu", "adad", 12, "ddd", null);
//        Usuario maria = new Usuario("Maria", "Juanu", "adad", 12, "ddd", null);
//
//        pepe.addAmistad(maria);
//        maria.aprobarAmistdad(maria.getAmistad(pepe));
//        System.out.println(maria.existeAmistad(pepe));
//        Publicacion p = new Texto("comentario de pepe", 1, pepe);
//     
//      //  pepe.comentar(p, paco);
//        maria.addAmistad(paco);
//        maria.aprobarAmistdad(maria.getAmistad(paco));
//        maria.comentar(p, paco);
//        //recuperar comentario
//        ArrayList<Publicacion> comentarios = maria.getMuroUsuario().getPublicaciones();
//        for (Publicacion comentario : comentarios) {
//            System.out.println(comentario);
//          
//        }

        //comenatrio a una publiucacion
        //    maria.comentar(p, maria);
        //recupero el muro  de maria entero
        //  Publicacion p = new Texto("s",2);
//        pepe.getMuroUsuario().addPublicacion(p, maria);
        //pepe.comentar(p, maria);
//        for (int i = 0; i < pepe.getAmigos().size(); i++) {
//            System.out.println("AMISTAD: " + i);
//            System.out.println("En la lista de pepe hay  :" + pepe.getAmigos().get(i).isAprobada());
//        }
        //     System.out.println("La amistad es:  "+ juan.existeAmistad(paco));
//  for (int i = 0; i < maria.getAmigos().size(); i++) {
//            System.out.println("AMISTAD: " + i);
//            System.out.println("En la lista de maria hay  :" + maria.getAmigos().get(i).isAprobada());
//        }
    }
}
