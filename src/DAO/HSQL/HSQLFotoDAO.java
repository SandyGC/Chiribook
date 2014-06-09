/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.HSQL;

import DAO.IFotoDAO;
import Modelo.Foto;
import com.ieschirinos.dam.hsqlchiribook.HSQLPublicacion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SandyG
 */
public class HSQLFotoDAO implements IFotoDAO{

    @Override
    public void create(Foto t) {
        try {
            HSQLPublicacion p = new HSQLPublicacion();
            p.insert(true,null,t.getImagen(), t.getFecha(), t.getFecha(), null, t.getUsuario().getId());
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(HSQLFotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Foto read(Foto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Foto> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Foto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Foto t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
