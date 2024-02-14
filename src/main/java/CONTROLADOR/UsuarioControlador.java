
package CONTROLADOR;

import MODELO.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 59398
 */
public class UsuarioControlador {
   private Usuario usuario ;

   ConexionBDD parametros = new ConexionBDD();
    Connection conectar = (Connection) parametros.conectar();
    PreparedStatement ejecutar;
    ResultSet res;
   
   
   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
    
public ArrayList<Object[]> datosUsuarios() {
    ArrayList<Object[]> listaObject = new ArrayList<>();

    try {
        String sql = "SELECT * FROM usuarios;";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);
        res = ejecutar.executeQuery();
        int cont = 1;
        while (res.next()) {
            Object[] obUsuario = new Object[4];
            obUsuario[0] = cont;
            obUsuario[1] = res.getObject("NOMBRE");
            obUsuario[2] = res.getObject("CONTRASENA");
            obUsuario[3] = res.getObject("ROLES");

            listaObject.add(obUsuario);
            cont++;
        }
        ejecutar.close();
        return listaObject;
    } catch (SQLException e) {
        System.out.println("ERROR SQL CARGA USUARIOS: " + e.getMessage());
    }

    return null;
}

public void insertarUsuario(Usuario usuario) {
    try {
        String sql = "call AgregarUsuario('" + usuario.getNombre() + "','" + usuario.getContraseña() + "','" + usuario.getRoles() + "')";
        ejecutar = (PreparedStatement) conectar.prepareCall(sql);

        int resultado = ejecutar.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Usuario Creado con Éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Revise los Datos ingresados");
        }

        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("ERROR SQL");
    }
}



public void eliminarUsuario(String nombre) {
    try {
        String sql = "CALL EliminarUsuario(?)";
        ejecutar = (PreparedStatement) conectar.prepareStatement(sql);
        ejecutar.setString(1, nombre);
        ejecutar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
    } catch (SQLException e) {
        System.out.println("Error al eliminar usuario: " + e.getMessage());
    } finally {
        try {
            if (ejecutar != null) {
                ejecutar.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
        }
    }
}




public void editarUsuario(String nombreAntiguo, String contraseniaAntigua, String RolAntiguo, String nuevoNombre, String nuevaContrasenia, String nuevosRoles) {
    try {
        String sql = "CALL EditarUsuario('" + nombreAntiguo + "', '" + contraseniaAntigua + "', '" + RolAntiguo + "', '" + nuevoNombre + "', '" + nuevaContrasenia + "', '" + nuevosRoles + "')";
        CallableStatement cs = conectar.prepareCall(sql);

        int resultado = cs.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Usuario editado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error al editar usuario");
        }

        cs.close();
    } catch (SQLException e) {
        System.out.println("Error al editar usuario: " + e.getMessage());
    }
}

public ArrayList<Object[]> buscarUsuarios(String nombreBuscado) {
    ArrayList<Object[]> listaObject = new ArrayList<>();

    try {
        String sql = "CALL sp_BuscarUsuariosPorNombre(?)";
        CallableStatement cs = conectar.prepareCall(sql);
        cs.setString(1, nombreBuscado);

        ResultSet rs = cs.executeQuery();

        int cont = 1; 

        while (rs.next()) {
            Object[] obUsuario = new Object[4]; 
            obUsuario[0] = cont;
            obUsuario[1] = rs.getObject("NOMBRE");
            obUsuario[2] = rs.getObject("CONTRASENA");
            obUsuario[3] = rs.getObject("ROLES");
            

            listaObject.add(obUsuario);

            cont++;
        }

        cs.close();
        return listaObject;
    } catch (SQLException e) {
        System.out.println("Error al buscar usuarios por nombre: " + e.getMessage());
    }

    return null;
}


}

   



