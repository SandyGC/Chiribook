/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorApp;

import DAO.DBConfig;
import DAO.IPublicacionDAO;
import Modelo.Foto;
import Modelo.Publicacion;
import Modelo.Texto;
import Modelo.Usuario;
import Vistas.MisGustos;
import Vistas.PanelGustoTexto;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author $Sandy.G
 */
public class ControladorGustos {

    private IPublicacionDAO daoPublicacion;
    private Usuario usuario;
    MisGustos vistaGustos;

    public ControladorGustos(Usuario us, MisGustos vistGustos, ResourceBundle bundle) {
        this.usuario = us;
        this.vistaGustos = vistGustos;
        daoPublicacion = DBConfig.getInstance().getFactoria().getPublicacionDAO();
        rellenarPanelGustos(bundle);
    }

    public final void rellenarPanelGustos(ResourceBundle bundle) {
       List<Publicacion> listaPubli= daoPublicacion.gustosDeUsuario(usuario);
        for (Publicacion publicacion : listaPubli) {
            if (publicacion instanceof Texto) {
                Texto publiTexto= (Texto) publicacion;
                PanelGustoTexto panelTexto= new PanelGustoTexto(publiTexto,bundle);
                vistaGustos.getPanelGustos().add(panelTexto);
                vistaGustos.getPanelGustos().updateUI();
            }
            if (publicacion instanceof Foto) {
                Foto publiFoto=(Foto)publicacion;
            }
        }
    }
}
