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
import com.ieschirinos.dam.hsqlchiribook.HSQLUsuario;
import com.ieschirinos.dam.hsqlchiribook.ImageConverter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        int idPublicacionPadre = 0;
        try {
            HSQLPublicacion p = new HSQLPublicacion();
            
            ResultSet rs = p.readAllOf(a.getId());
            if (rs.next()) {
                do {
                    if (rs.getString("comentario_de") == null) {
                        idPublicacionPadre = rs.getInt("id");
                        if (rs.getBoolean("tipofoto")) {
                            Publicacion p1 = new Foto(rs.getBytes("foto"), rs.getInt("id"), rs.getDate("fecha"), a);
                            publicaciones.add(p1);
                        } else {
                            Publicacion p2 = new Texto(rs.getString("texto"), rs.getInt("id"), rs.getDate("fecha"), a);
                            publicaciones.add(p2);
                            
                        }
                    }


                    //Recuperamos los comentario de las publicaiones y las añadimos 
//                ResultSet rsComent = p.readComentsOf(idPublicacionPadre);
//                while (rsComent.next()) {
//                    for (int i = 0; i < publicaciones.size(); i++) {
//                        int idPubliPadre = publicaciones.get(i).getId();
//                        int idPublicacionComentario = rsComent.getInt("comentario_de");
//                        if (idPubliPadre == idPublicacionComentario) {
//                            HSQLUsuario hsqlUsuario = new HSQLUsuario();
//                           //recupero el usuario con el id que obtengo de la publicacion
//                            ResultSet rsUsuario = hsqlUsuario.read(rs.getInt("usuario"));
//                            Usuario usuario = new Usuario();
//                            while (rsUsuario.next()) {                                
//                                usuario.setId(rsUsuario.getInt("id"));
//                                usuario.setNombreCompleto(rsUsuario.getString("nombre"));
//                                usuario.setEmail(rsUsuario.getString("email"));
//                                usuario.setFotoPerfil(rsUsuario.getBytes("foto"));
//                                usuario.setEdad(rsUsuario.getInt("edad"));
//                                
//                            }
//                            //contruyo el comentario
//                            Publicacion pComentario = new Publicacion(rsComent.getInt("id"), 
//                                    rsComent.getDate("fecha"),usuario );
//                                    
//                            publicaciones.get(i).getComentarios().add(pComentario);
//                        }
//                    }
//                }

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
            HSQLPublicacion publi = new HSQLPublicacion();
            ResultSet rs = gustos.readAllOf(us.getId());
            while (rs.next()) {
                int idP = rs.getInt("publicacion");
                ResultSet rsPublicacion = publi.read(idP);
                while (rsPublicacion.next()) {
                    if (rsPublicacion.getBoolean("tipofoto") == true) {
                        byte[] foto = rsPublicacion.getBytes("foto");
                        int id = rsPublicacion.getInt("id");
                        Publicacion publiFoto = new Foto(foto, id, us);
                        publicaciones.add(publiFoto);
                    } else {
                        String men = rsPublicacion.getString("texto");
                        int idT = rsPublicacion.getInt("id");
                        Publicacion publiTexto = new Texto(men, idT, us);
                        publicaciones.add(publiTexto);
                    }
                    
                }
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publicaciones;
        
    }
    
    @Override
    public List<Publicacion> comentariosDePublicacion(Publicacion p) {
        List<Publicacion> comentarios = new ArrayList<>();
        try {
            HSQLPublicacion hsqlPublicacion = new HSQLPublicacion();
            ResultSet rsComentarios = hsqlPublicacion.readComentsOf(p.getId());
            Publicacion comentario = null;
            Usuario usuario = null;
            while (rsComentarios.next()) {
                if (rsComentarios.getBoolean("tipofoto") == true) {
                    byte[] foto = rsComentarios.getBytes("foto");
                    int idComentarioFoto = rsComentarios.getInt("id");//id del comentario
                    int idUsuarioRealizaPubli = rsComentarios.getInt("usuario");//id del usuario que realiza el coment
                    HSQLUsuario hsqlUsuario = new HSQLUsuario();
                    //utilizo el id que me devuelve el comentario para obtener el objeto usuario de ese comentario
                    ResultSet rsUsuario = hsqlUsuario.read(idUsuarioRealizaPubli);
                    while (rsUsuario.next()) {
                        usuario = new Usuario();
                        usuario.setId(rsUsuario.getInt("id"));
                        usuario.setEdad(rsUsuario.getInt("edad"));
                        usuario.setFotoPerfil(rsUsuario.getBytes("foto"));
                        usuario.setNombreCompleto(rsUsuario.getString("nombre"));
                    }
                    
                    Publicacion publiFoto = new Foto(foto, idComentarioFoto, usuario);
                    comentarios.add(publiFoto);
                } else {
                    String texto = rsComentarios.getString("texto");
                    int idComentarioTexto = rsComentarios.getInt("id");//id del comentario
                    int idUsuarioRealizaPubli = rsComentarios.getInt("usuario");//id del usuario que realiza el coment
                    HSQLUsuario hsqlUsuario = new HSQLUsuario();
                    //utilizo el id que me devuelve el comentario para obtener el objeto usuario de ese comentario
                    ResultSet rsUsuario = hsqlUsuario.read(idUsuarioRealizaPubli);
                    while (rsUsuario.next()) {
                        usuario = new Usuario();
                        usuario.setId(rsUsuario.getInt("id"));
                        usuario.setEdad(rsUsuario.getInt("edad"));
                        usuario.setFotoPerfil(rsUsuario.getBytes("foto"));
                        usuario.setNombreCompleto(rsUsuario.getString("nombre"));
                    }
                    
                    Publicacion publiTexto = new Texto(texto, idComentarioTexto, usuario);
                    comentarios.add(publiTexto);
                }
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HSQLPublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentarios;
        
    }
}
