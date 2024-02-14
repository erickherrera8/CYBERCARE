 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 59398
 */
public class ConexionBDD {
  
    java.sql.Connection conexion;
     public java.sql.Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","1234");
            System.out.println("CONECTADO A LA BASE DE DATOS"); 
        } catch (ClassNotFoundException | SQLException e)
        {
             System.out.println("ERROR DE CONEXION A LA BASE DE DATOS");
        }
        return conexion;
    }
    
}
