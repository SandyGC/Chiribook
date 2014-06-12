/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOHSQL;

import DAO.IAmistadDAO;
import DAO.IFactoriaDAO;
import DAO.IFotoDAO;
import DAO.IMuroDAO;
import DAO.IPublicacionDAO;
import DAO.ITextoDAO;
import DAO.IUsuarioDAO;

/**
 *
 * @author SandyG
 */
public class HSQLFactoriaDAO implements IFactoriaDAO{

    @Override
    public IAmistadDAO getAmistadDAO() {
        
    return new HSQLAmistadDAO();
    }

    @Override
    public IFotoDAO getFotoDAO() {
      return new HSQLFotoDAO();
    }

 

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new HSQLUsuarioDAO();
    }

    @Override
    public IPublicacionDAO getPublicacionDAO() {
     return new HSQLPublicacionDAO();
    }

    @Override
    public ITextoDAO getTextoDAO() {
       return new HSQLTextoDAO();
    }

    @Override
    public IMuroDAO getMuroDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

  

}
