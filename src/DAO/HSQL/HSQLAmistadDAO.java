/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.HSQL;

import DAO.IAmistadDAO;
import Modelo.Amistad;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.HSQLAmistad;
import com.ieschirinos.dam.hsqlchiribook.HSQLUsuario;
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
public class HSQLAmistadDAO implements IAmistadDAO {

    @Override
    public void create(Amistad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Amistad read(Amistad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Amistad> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Amistad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Amistad t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Amistad> devolverAmigos(Usuario u) {
        List<Amistad> amigos = new ArrayList<>();
        Usuario s;
        try {
            HSQLAmistad amistad = new HSQLAmistad();
            HSQLUsuario usuario = new HSQLUsuario();
            ResultSet r = amistad.readAllOf(u.getId());

            if (r.next()) {

                do {
                    int us = r.getInt("usuario2");
                    ResultSet rUsuario = usuario.read(us);
                    if (rUsuario.next()) {
                        do {
                            String nombre = rUsuario.getString("nombre");
                            String pas = rUsuario.getString("password");
                            s = new Usuario(nombre, pas);
                        } while (rUsuario.next());
                        String tipo = r.getString("tipo");
                        boolean apro = r.getBoolean("aprobada");
                        Amistad a = new Amistad(s, apro, tipo);
                        amigos.add(a);
                    }

                } while (r.next());

            } 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HSQLAmistadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amigos;
    }

}
