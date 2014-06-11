/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.HSQL;

import DAO.IUsuarioDAO;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.HSQLUsuario;
import java.io.IOException;
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
public class HSQLUsuarioDAO implements IUsuarioDAO {

    @Override
    public void create(Usuario t) {
        try {
            HSQLUsuario u = new HSQLUsuario();
            u.insert(t.getNombreCompleto(), t.getEdad(), t.getEmail(), t.getContraseña(), t.getFotoPerfil());

        } catch (SQLException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario read(Usuario t) {
        try {
            HSQLUsuario u = new HSQLUsuario();
            ResultSet r = u.readWhere("\"nombre\" = '" + t.getNombreCompleto() + "' and \"password\"='" + t.getContraseña() + "'");
            Usuario a = null;
            while (r.next()) {
                int id = r.getInt("id");
                String n = r.getString("nombre");
                int e = r.getInt("edad");
                String em = r.getString("email");
                String pas = r.getString("password");
                byte[] foto = r.getBytes("foto");
                a = new Usuario(id, n, em, e, pas, foto);
            }
            return a;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HSQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<Usuario> readAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            HSQLUsuario u = new HSQLUsuario();
            ResultSet r = u.readAll();

            while (r.next()) {
                Usuario us = new Usuario();
                us.setId(r.getInt("id"));
                us.setEdad(r.getInt("edad"));
                us.setEmail(r.getString("email"));
                us.setFotoPerfil(r.getBytes("foto"));
                us.setNombreCompleto(r.getString("nombre"));
                us.setContraseña(r.getString("password"));
                usuarios.add(us);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public void update(Usuario t) {
        try {
            HSQLUsuario u = new HSQLUsuario();
            u.update(t.getId(), t.getNombreCompleto(), t.getEdad(), t.getEmail(), t.getContraseña(), t.getFotoPerfil());
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(HSQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
