/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author SANGYG
 */
public interface IFactoriaDAO {
    public IAmistadDAO getAmistadDAO();
    public IFotoDAO getFotoDAO();
    public ITextoDAO getITextoDAO();
    public IUsuarioDAO getUsuarioDAO();
    public IPublicacionDAO getPublicacionDAO();
    public IMuroDAO getIMuroDAO();
}
