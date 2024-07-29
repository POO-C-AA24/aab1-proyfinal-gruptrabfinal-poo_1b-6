package Modelo;

import Controlador.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionDB {

    private Connection concDB;
    private ArrayList<Cliente> lstClientes;
    private String msj;

    public void setConcDB(String url) {
        try {
            this.concDB = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
            System.err.println("Error al establecer la conexión: " + msj);
        }
    }
public ArrayList<Cliente> getClientesPorCedula(int cedula) {
    ArrayList<Cliente> lstClientes = new ArrayList<>();
    try {
        setConcDB("jdbc:sqlite:C:\\Users\\Roble\\OneDrive\\Documents\\NetBeansProjects\\Proyecto_Final_2\\db\\dbClientes.db");
        Statement statement = concDB.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE cedulaRuc = " + cedula);
        while (resultSet.next()) {
            lstClientes.add(new Cliente(
                    resultSet.getString("nombreCliente"),
                    resultSet.getString("apellidoCliente"),
                    resultSet.getInt("cedulaRuc"),
                    resultSet.getInt("numTelefonico"),
                    resultSet.getString("producto"),
                    resultSet.getInt("cantidad"),
                    resultSet.getString("tipoProducto")));
        }
        resultSet.close();
        statement.close();
        concDB.close();
    } catch (SQLException sqlException) {
        this.msj = sqlException.getMessage();
        System.err.println("Error al obtener clientes: " + msj);
    }
    return lstClientes;
}

  public void insertarCliente(Cliente cliente) {
    try {
        setConcDB("jdbc:sqlite:C:\\Users\\Roble\\OneDrive\\Documents\\NetBeansProjects\\Proyecto_Final_2\\db\\dbClientes.db");
        Statement statement = concDB.createStatement();
        String strInsertEst = String.format(
            "INSERT INTO Cliente(nombreCliente, apellidoCliente, cedulaRuc, numTelefonico, producto, cantidad, tipoProducto) " +
            "VALUES('%s', '%s', %d, %d, '%s', %d, '%s')",
            cliente.nombreCliente, cliente.apellidoCliente, cliente.cedulaRuc, cliente.numTelefonico, 
            cliente.producto, cliente.cantidad, cliente.tipoProducto
        );
        statement.executeUpdate(strInsertEst);
        statement.close();
        concDB.close();
    } catch (SQLException sqlException) {
        this.msj = sqlException.getMessage();
        System.err.println("Error al insertar cliente: " + msj);
    }
} 

    // Método de ejemplo para buscar cliente por cédula
    public Cliente buscarClientePorCedula(int cedula) {
        Cliente cliente = null;
        try {
            setConcDB("jdbc:sqlite:C:\\Users\\Roble\\OneDrive\\Documents\\NetBeansProjects\\Proyecto_Final_2\\db\\dbClientes.db");
            Statement statement = concDB.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente WHERE cedulaRuc = " + cedula);
            if (resultSet.next()) {
                cliente = new Cliente(
                        resultSet.getString("nombreCliente"),
                        resultSet.getString("apellidoCliente"),
                        resultSet.getInt("cedulaRuc"),
                        resultSet.getInt("numTelefonico"),
                        resultSet.getString("producto"),
                        resultSet.getInt("cantidad"),
                        resultSet.getString("tipoProducto")
                );
            }
            resultSet.close();
            statement.close();
            concDB.close();
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
            System.err.println("Error al obtener cliente: " + msj);
        }
        return cliente;
    }

}
