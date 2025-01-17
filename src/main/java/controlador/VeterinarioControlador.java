/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.VeterinarioModelo;

/**
 *
 * @author Usuario
 */
public class VeterinarioControlador {

    // INSTANCIO UN OBJETO DEL MODELO A INSERTAR
    private VeterinarioModelo v;
    // INSTANCIAR LA CONEXIÓN A LA BASE DE DATOS
    ConexionBDD conectar = new ConexionBDD();
    // CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
    Connection conectado = (Connection) conectar.conectar();
    // CLASE QUE ME PERMITE EJECUTAR MI SENTENCIA SQL
    PreparedStatement ejecutar;
    // OBTENER RESULTADOS DE LA CONSULTA
    ResultSet res;

    // MÉTODOS DE TRANSACCIONABILIDAD

    /**
     * Método para insertar un veterinario.
     * @param v Objeto VeterinarioModelo con los datos del veterinario a insertar.
     */
    public void insertarVeterinario(VeterinarioModelo v) {
        try {
            String sentenciaSQL = "call sp_InsertarVeterinario('" + v.getIdPersonas() + "','" + v.getNombres() + "','" 
                + v.getApellidos() + "','" + v.getEspecialidad() + "','" + v.getTelefonoContacto() + "','" 
                + v.getCorreoElectronico() + "');";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            int resu = ejecutar.executeUpdate();
            if (resu > 0) {
                JOptionPane.showMessageDialog(null, "Veterinario Creado con éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "El Veterinario no ha sido creado, revise los datos ingresados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el veterinario. Comuniquese con el administrador.");
        }
    }

    /**
     * Método para buscar veterinarios por especialidad.
     * @param especialidad La especialidad del veterinario a buscar.
     * @return Una lista de objetos con los datos de los veterinarios encontrados.
     */
    public ArrayList<Object[]> buscarVeterinario(String especialidad) {
        ArrayList<Object[]> listaObject = new ArrayList<>();
        try {
            String sql = "call sp_BuscarVeterinario('" + especialidad + "');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            res = ejecutar.executeQuery();
            int cont = 1;
            while (res.next()) {
                Object[] obVeterinario = new Object[6];
                for (int i = 0; i < 6; i++) {
                    obVeterinario[i] = res.getObject(i + 1);
                }
                obVeterinario[0] = cont;
                listaObject.add(obVeterinario);
                cont++;
            }
            ejecutar.close();
            return listaObject;
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e);
        }
        return null;
    }

    /**
     * Método para listar todos los veterinarios.
     * @return Una lista de objetos con los datos de todos los veterinarios.
     */
    public ArrayList<Object[]> datosVeterinario() {
        ArrayList<Object[]> listaObject = new ArrayList<>();
        try {
            String sql = "call sp_ListaVeterinarios();";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            res = ejecutar.executeQuery();
            int cont = 1;
            while (res.next()) {
                Object[] obVeterinario = new Object[6];
                for (int i = 1; i < 6; i++) {
                    obVeterinario[i] = res.getObject(i + 1);
                }
                obVeterinario[0] = cont;
                listaObject.add(obVeterinario);
                cont++;
            }
            ejecutar.close();
            return listaObject;
        } catch (SQLException e) {
            System.out.println("ERROR SQL CARGA VETERINARIOS: " + e);
        }
        return null;
    }

    /**
     * Método para actualizar un veterinario.
     * @param v Objeto VeterinarioModelo con los datos actualizados.
     */
    public void actualizarVeterinario(VeterinarioModelo v) {
        try {
            String sentenciaSQL = "call sp_ActualizarVeterinario('" + v.getIdPersonas() + "','" + v.getNombres() + "','" 
                + v.getApellidos() + "','" + v.getEspecialidad() + "','" + v.getTelefonoContacto() + "','" 
                + v.getCorreoElectronico() + "');";
            ejecutar = (PreparedStatement) conectado.prepareCall(sentenciaSQL);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Veterinario Actualizado con Éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e);
        }
    }

    /**
     * Método para eliminar un veterinario por ID.
     * @param idPersona El ID del veterinario a eliminar.
     */
    public void eliminarVeterinario(int idPersona) {
        try {
            String sql = "call sp_EliminarVeterinario(" + idPersona + ");";
            ejecutar = (PreparedStatement) conectado.prepareCall(sql);
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Veterinario Eliminado con éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null, "Revise los datos ingresados");
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL: " + e);
        }
    }
}
