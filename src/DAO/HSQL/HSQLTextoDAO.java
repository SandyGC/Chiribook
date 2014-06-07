/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.HSQL;

import DAO.ITextoDAO;
import Modelo.Texto;
import com.ieschirinos.dam.hsqlchiribook.HSQLPublicacion;
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
          //  p.insert(false, t.getComentario(), foto, t.getFecha(), null, Integer.MIN_VALUE, t.getUsuario());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HSQLTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Texto read(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Texto> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Texto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
