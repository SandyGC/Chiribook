/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SandyG
 */
public class UtilConnectionHSQL {

    // JDBC driver name and database URL
    private final String JDBC_DRIVER;
    private final String DB_URL;

    //  Database credentials
    private final String USER;
    private final String PASS;

    public UtilConnectionHSQL(String J, String DB_URL, String USER, String PASS) {
        this.JDBC_DRIVER = "org." + J + "db.jdbcDriver";
        this.DB_URL = "jdbc:hsqldb:file:" + DB_URL + "/chiribook.hsql.db";
        this.USER = USER;
        this.PASS = "";
    }

    public Connection crearConexion() {
        Connection conn = null;
        try {

            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("conexion"+ex.getMessage());
        }
        return conn;
    }

}
