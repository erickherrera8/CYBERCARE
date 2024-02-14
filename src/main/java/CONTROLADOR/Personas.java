/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CONTROLADOR;

import MODELO.Persona;
import MODELO.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guami
 */
public class Personas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Personas
     */
    public Personas() {
        initComponents();
         setModelo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersona = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarPersona = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEliminarUsuario = new javax.swing.JButton();
        txtTelefono = new javax.swing.JTextField();
        btnModificarUsuario = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTablePersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePersona);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarPersona.setText("Agregar");
        btnAgregarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 388, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, -1));

        jLabel1.setText("Apellido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 163, -1, -1));

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 83, -1, -1));

        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 303, -1, -1));

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 388, -1, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 150, -1));

        btnModificarUsuario.setText("Modificar");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 455, -1, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 455, -1, -1));

        jLabel4.setText("Cedula");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 233, -1, -1));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 150, -1));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePersonaMouseClicked
        DefaultTableModel modeloP = (DefaultTableModel) jTablePersona.getModel();
        txtNombre.setText((String) modeloP.getValueAt(jTablePersona.getSelectedRow(), 1));
        txtApellido.setText((String) modeloP.getValueAt(jTablePersona.getSelectedRow(), 2));
        txtCedula.setText((String) modeloP.getValueAt(jTablePersona.getSelectedRow(), 3));
        txtTelefono.setText((String) modeloP.getValueAt(jTablePersona.getSelectedRow(), 4));
        
    }//GEN-LAST:event_jTablePersonaMouseClicked

    private void btnAgregarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPersonaActionPerformed
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtApellido.getText();
        String telefono = txtTelefono.getText();

        Persona pM = new Persona(nombre, apellido, cedula, telefono);

        PersonaControlador personaControlador = new PersonaControlador();
        personaControlador.insertarPersona(pM);
        listaPersonas.add(pM);
        setDatos(pM);


    }//GEN-LAST:event_btnAgregarPersonaActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
   int filaSeleccionada = jTablePersona.getSelectedRow();

    if (filaSeleccionada >= 0) {
        DefaultTableModel modelo = (DefaultTableModel) jTablePersona.getModel();
        String cedula = modelo.getValueAt(filaSeleccionada, 3).toString(); // Assuming cedula is in the fourth column

        PersonaControlador personaControlador = new PersonaControlador();
        personaControlador.EliminarPersona(cedula);

        modelo.removeRow(filaSeleccionada);
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
    }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
   int filaSeleccionada = jTablePersona.getSelectedRow();

    if (filaSeleccionada >= 0) {
        String cedula = jTablePersona.getValueAt(filaSeleccionada, 3).toString();
        String nuevoNombre = txtNombre.getText();
        String nuevoApellido = txtApellido.getText();
        String nuevoTelefono = txtTelefono.getText();

        PersonaControlador personaControlador = new PersonaControlador();
        personaControlador.editarPersona(cedula, nuevoNombre, nuevoApellido, nuevoTelefono);

        // Clear the existing rows in the table model
        modeloPersona.setRowCount(0);

        // Refresh the table after editing
        setModelo();
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una fila para editar");
    }


    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
String cedulaBuscada = txtApellido.getText();

    if (!cedulaBuscada.isEmpty()) {
        PersonaControlador personaControlador = new PersonaControlador();
        ArrayList<Object[]> resultados = personaControlador.buscarPersona(cedulaBuscada);

        DefaultTableModel modelo = (DefaultTableModel) jTablePersona.getModel();
        modelo.setRowCount(0);

        if (resultados != null) {
            for (Object[] fila : resultados) {
                modelo.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al buscar personas por cédula");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Ingrese una cédula para buscar");
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    
    
   private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private DefaultTableModel modeloPersona = new DefaultTableModel();
    
public void setModelo() {
    modeloPersona.setRowCount(0); 

    String[] cabecera = {"Nro.", "Nombres", "Apellidos", "Cédula", "Teléfono"};
    modeloPersona.setColumnIdentifiers(cabecera);

    PersonaControlador personaControlador = new PersonaControlador();
    ArrayList<Object[]> datos = personaControlador.datosPersonas();

    if (datos != null) {
        for (Object[] fila : datos) {
            modeloPersona.addRow(fila);
        }
    }

    jTablePersona.setModel(modeloPersona);
}


public void setDatos(Persona persona) {
    DefaultTableModel modelo = (DefaultTableModel) jTablePersona.getModel();
    Object[] fila = new Object[5];

    fila[0] = modelo.getRowCount() + 1;
    fila[1] = persona.getNombre();
    fila[2] = persona.getApellido();
    fila[3] = persona.getCedula();
    fila[4] = persona.getTelefono();

    modelo.addRow(fila);
    jTablePersona.setModel(modelo);
    txtNombre.setText("");
    txtApellido.setText("");
    txtApellido.setText("");
    txtTelefono.setText("");
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPersona;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}