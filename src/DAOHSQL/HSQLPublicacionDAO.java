/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOHSQL;

import DAO.IPublicacionDAO;
import Modelo.Foto;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import com.ieschirinos.dam.hsqlchiribook.HSQLGustos;
import com.ieschirinos.dam.hsqlchiribook.HSQLPublicacion;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                do {
                    if (rs.getBoolean("tipofoto")) {
                        Publicacion p1 = new Foto(rs.getBytes("foto"), rs.getInt("id"), a);
                        publicaciones.add(p1);
                    } else {
                        Publicacion p2 = new Texto(rs.getString("texto"), rs.getInt("id"), a);
                        publicaciones.add(p2);

                    }
                } while (rs.next());

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return publicaciones;
    }

    @Override
    public void guardarGustos(Usuario usuarioAccion, Publicacion p) {
        try {
            HSQLGustos gustos = new HSQLGustos();
            gustos.insert(usuarioAccion.getId(), p.getId());
            HSQLPublicacion pu = new HSQLPublicacion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Publicacion> gustosDeUsuario(Usuario us) {
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            HSQLGustos gustos = new HSQLGustos();
            HSQLPublicacion publi= new HSQLPublicacion();
            ResultSet rs = gustos.readAllOf(us.getId());
            Publicacion publicacion = null;
            while (rs.next()) {
                int idP=rs.getInt("publicacion");
               ResultSet rsPublicacion= publi.read(idP);
                while (rsPublicacion.next()) {
                    if (rsPublicacion.getBoolean("tipofoto")==true) {
                       byte[]foto=rsPublicacion.getBytes("foto");
                       
                       // Publicacion publiFoto= new Foto(foto, idP, us);
                       //hola esto deberia sair eb masrter
                    }else {
                    Publicacion publiTexto=new Texto(null, idP, us);
                    
                    }
 
                    
                    
                 
                }
               
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
