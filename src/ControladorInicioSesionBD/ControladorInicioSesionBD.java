/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorInicioSesionBD;


import ControladorLogin.ControladorLogin;
import DAO.UtilConnectionHSQL;
import VistaInicioSesionBD.VistaInicio;
import VistaLoginApp.Login;


/**
 *
 * @author SandyG
 */
public class ControladorInicioSesionBD {

    VistaInicio vista;
    
    public ControladorInicioSesionBD(VistaInicio vista) {
        this.vista = vista;
       
    }
    
    
    public void iniciarSesion(String driver,String host,String nameDB,String pass){
        
        UtilConnectionHSQL connection= new UtilConnectionHSQL(driver,"db",nameDB,pass);
        if (connection.crearConexion()==null) {
            vista.getErrorBD().setText("No se puede conectar a la BD");
        }else{
        vista.getErrorBD().setText("Conexion correcta");
        //si la conexion es correcta creo mi nueva ventana y cierro la de la conexion con la base de datos
            Login l= new Login();
            
            l.setVisible(true);
            vista.cerrarVista();
      
        }
        
    }

}
