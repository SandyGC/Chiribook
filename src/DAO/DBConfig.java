/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DAO.HSQL.HSQLFactoriaDAO;

/**
 *
 * @author SandyG
 */
public class DBConfig {
    private static DBConfig instance;
    
    private DBConfig(){
    };
    
    public static DBConfig getInstance() {
        if(instance == null) instance = new DBConfig();
        return instance;
    }
    
    /**
     * En este método se centraliza la creación de la factoría.
     * Por tanto, para cambiar de base de datos, basta con
     * cambiar el new MySQLFactoriaDAO por la base de datos 
     * nueva (ej. OracleFactoriaDAO) en este método.
     * @return 
     */
    public IFactoriaDAO getFactoria() {
     
        return new HSQLFactoriaDAO();
    }
}
