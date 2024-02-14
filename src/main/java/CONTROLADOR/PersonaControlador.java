
package CONTROLADOR;

import MODELO.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guami
 */
public class PersonaControlador {
   
       private Persona persona ;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
       
       

    ConexionBDD parametros = new ConexionBDD();
    Connection conectar = (Connection) parametros.conectar();
    PreparedStatement ejecutar;
    ResultSet res;
   
 public ArrayList<Object[]> datosPersonas() {
        ArrayList<Object[]> ListaObject = new ArrayList<>();

        try {
            String callProcedure = "{CALL ListaPersona()}";
            try (CallableStatement callableStatement = conectar.prepareCall(callProcedure);
                 ResultSet resultSet = callableStatement.executeQuery()) {

                int count = 1;
                while (resultSet.next()) {
                    Object[] personData = new Object[5];
                    personData[0] = count;
                    personData[1] = resultSet.getObject("IDPERSONA");
                    personData[2] = resultSet.getObject("NOMBRE");
                    personData[3] = resultSet.getObject("APELLIDO");
                    personData[4] = resultSet.getObject("CEDULA");

                    ListaObject.add(personData);
                    count++;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        }

        return ListaObject;
    }

    
     public void insertarPersona(Persona persona) {
        try {
            String sql = "call AgregarPersona(?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conectar.prepareCall(sql)) {
                preparedStatement.setString(1, persona.getNombre());
                preparedStatement.setString(2, persona.getApellido());
                preparedStatement.setString(3, persona.getCedula());
                preparedStatement.setString(4, persona.getTelefono());

                int resultado = preparedStatement.executeUpdate();

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Persona Creada con Éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Revise los Datos ingresados");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        }
    }
    
    
     
     public void EliminarPersona(String cedula) {
         
        String callProcedure = "{CALL EliminarPersona(?)}";

        try (Connection connection = parametros.conectar();
             PreparedStatement preparedStatement = connection.prepareCall(callProcedure)) {

            preparedStatement.setString(1, cedula);
            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Persona eliminada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la persona con la cédula proporcionada.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar persona.");
        }
    }

     
     
    public ArrayList<Object[]> buscarPersona(String cedulaBuscada) {
    ArrayList<Object[]> listaObject = new ArrayList<>();

    try {
        String callProcedure = "{CALL BuscarPersona(?)}";
        try (Connection connection = parametros.conectar();
             CallableStatement callableStatement = connection.prepareCall(callProcedure)) {

            callableStatement.setString(1, cedulaBuscada);

            try (ResultSet resultSet = callableStatement.executeQuery()) {
                int cont = 1;

                while (resultSet.next()) {
                    Object[] obPersona = new Object[5];  
                    obPersona[0] = cont;
                    obPersona[1] = resultSet.getObject("NOMBRE");
                    obPersona[2] = resultSet.getObject("APELLIDO");
                    obPersona[3] = resultSet.getObject("CEDULA");
                    obPersona[4] = resultSet.getObject("TELEFONO");

                    listaObject.add(obPersona);

                    cont++;
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar personas por cédula: " + e.getMessage());
    }

    return listaObject;
}

    public void editarPersona(String cedula, String nuevoNombre, String nuevoApellido, String nuevoTelefono) {
    try {
        String sql = "CALL EditarPersona(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conectar.prepareCall(sql)) {
            preparedStatement.setString(1, cedula);
            preparedStatement.setString(2, nuevoNombre);
            preparedStatement.setString(3, nuevoApellido);
            preparedStatement.setString(4, nuevoTelefono);

            int resultado = preparedStatement.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Persona editada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar la persona. Revise los datos ingresados.");
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL ERROR: " + e.getMessage());
    }
}


     
}
