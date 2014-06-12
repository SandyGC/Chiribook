/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOHSQL;

import DAO.ITextoDAO;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.HSQLPublicacion;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SandyG
 */
public class HSQLTextoDAO implements ITextoDAO {

    @Override
    public void create(Texto t) {
        try {
            HSQLPublicacion p = new HSQLPublicacion();
          int id= p.insert(false, t.getComentario(),null, t.getFecha(), t.getFecha(), null, t.getUsuario().getId());
            devolverIdPublicacion(id);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(ITextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Texto read(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Texto> readAll() {
        try {
            HSQLPublicacion h = new HSQLPublicacion();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ITextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void crearComentario(Usuario a,Texto t) {
//        try {
//            HSQLPublicacion p = new HSQLPublicacion();
//            p.insert(false, t.getComentario(), null, t.getFecha(), t.getFecha(), , t.getUsuario().getId());
//        } catch (ClassNotFoundException | SQLException | IOException ex) {
//            Logger.getLogger(HSQLTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void crearComentario(Usuario a, Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int devolverIdPublicacion(int id) {
        return id;
    }


}
