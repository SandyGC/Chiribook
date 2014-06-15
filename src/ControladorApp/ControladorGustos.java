/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControladorApp;

import DAO.DBConfig;
import DAO.IPublicacionDAO;

/**
 *
 * @author $Sandy.G
 */
public class ControladorGustos {
    private IPublicacionDAO daoPublicacion;

    public ControladorGustos() {
        daoPublicacion= DBConfig.getInstance().getFactoria().getPublicacionDAO();
    }
    public void rellenarPanelGustos(){
    
    
    }
}
