/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.HSQL;

import DAO.IPublicacionDAO;
import Modelo.Foto;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.HSQLPublicacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SandyG
 */
public class HSQLPublicacionDAO implements IPublicacionDAO {

    @Override
    public void create(Publicacion t) {

    }

    @Override
    public Publicacion read(Publicacion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> readAll() {
        return null;

    }

    @Override
    public void update(Publicacion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Publicacion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publicacion> publicacionfromUser(Usuario a) {
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            HSQLPublicacion p = new HSQLPublicacion();
            
            ResultSet rs = p.readAllOf(a.getId());
            if (rs.next()) {
                while (rs.next()) {
                    if (rs.getBoolean("tipofoto")) {

                        Publicacion p1 = new Foto(rs.getBytes("foto"), a);
                          System.out.println(p1.toString());
                        publicaciones.add(p1);
                      
                    } else {

                        Publicacion p2 = new Texto(rs.getString("texto"), a);
                              System.out.println(p2.toString());
                        publicaciones.add(p2);
                  
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return publicaciones;
    }

}
