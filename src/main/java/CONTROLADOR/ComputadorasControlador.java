/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

/**
 *
 * @author 59398
 */
import MODELO.Computadoras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ComputadorasControlador {
    private Computadoras computadoras;

    ConexionBDD parametros = new ConexionBDD();
    Connection conectar = (Connection) parametros.conectar();
    PreparedStatement ejecutar;
    ResultSet res;


    public Computadoras getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(Computadoras computadoras) {
        this.computadoras = computadoras;
    }

public ArrayList<Object[]> datosComputadoras() {
    ArrayList<Object[]> listaObject = new ArrayList<>();

    try {
        String sql = "SELECT * FROM computadoras;";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);
        res = ejecutar.executeQuery();
        int cont = 1;
        while (res.next()) {
            Object[] obComputadora = new Object[3];
            obComputadora[0] = cont;
            obComputadora[1] = res.getObject("MARCA");
            obComputadora[2] = res.getObject("PROBLEMA");

            listaObject.add(obComputadora);
            cont++;
        }
        ejecutar.close();
        return listaObject;
    } catch (SQLException e) {
        System.out.println("ERROR SQL CARGA COMPUTADORAS: " + e.getMessage());
    }

    return null;
}






  public void insertarComputadora(Computadoras computadora) {
    try {
        String sql = "INSERT INTO computadoras (MARCA, PROBLEMA) VALUES (?, ?)";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);

        ejecutar.setString(1, computadora.getMarca());
        ejecutar.setString(2, computadora.getProblema());

        int resultado = ejecutar.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Computadora Agregada con Éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Revise los Datos ingresados");
        }

        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("ERROR SQL al insertar computadora: " + e.getMessage());
    }
}

  
  
  

   public void eliminarComputadora(int idComputadora, String marca, String problema) {
    try {
        String sql = "DELETE FROM computadoras WHERE ID_COMPUTADORA = ?";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);

        ejecutar.setInt(1, idComputadora);

        int resultado = ejecutar.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Computadora eliminada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la computadora");
        }

        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("Error SQL al eliminar computadora: " + e.getMessage());
    }
}

   
   public void editarComputadora(int idAntiguo, String marcaAntigua, String problemaAntiguo, String nuevaMarca, String nuevoProblema) {
    try {
        String sql = "UPDATE computadoras SET MARCA = ?, PROBLEMA = ? WHERE ID_COMPUTADORA = ?";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);

        ejecutar.setString(1, nuevaMarca);
        ejecutar.setString(2, nuevoProblema);
        ejecutar.setInt(3, idAntiguo);

        int resultado = ejecutar.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Computadora editada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error al editar computadora");
        }

        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("Error al editar computadora: " + e.getMessage());
    }
}

public ArrayList<Object[]> buscarComputadoras(String marcaBuscada) {
    ArrayList<Object[]> listaObject = new ArrayList<>();

    try {
        String sql = "SELECT * FROM computadoras WHERE MARCA LIKE CONCAT('%', ?, '%')";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);
        ejecutar.setString(1, marcaBuscada);

        ResultSet rs = ejecutar.executeQuery();

        int cont = 1;

        while (rs.next()) {
            Object[] obComputadora = new Object[3];
            obComputadora[0] = cont;
            obComputadora[1] = rs.getObject("MARCA");
            obComputadora[2] = rs.getObject("PROBLEMA");

            listaObject.add(obComputadora);

            cont++;
        }

        ejecutar.close();
        return listaObject;
    } catch (SQLException e) {
        System.out.println("Error al buscar computadoras por marca: " + e.getMessage());
    }

    return null;
}
}



