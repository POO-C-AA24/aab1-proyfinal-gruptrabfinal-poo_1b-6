package Controlador;

import Modelo.ConexionDB;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public String nombreCliente;
    public String apellidoCliente;
    public int cedulaRuc;
    public int numTelefonico;
    public String producto;
    public int cantidad;
    public String tipoProducto;

    //agregar  los atributos cantidad producto y eso, y poner el nuevo constructor con todos los parametros
    //sus getters y setters tambien

    public Cliente( String nombreCliente, String apellidoCliente, int cedulaRuc, int numTelefonico, String producto, int cantidad, String tipoProducto) {
 
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.cedulaRuc = cedulaRuc;
        this.numTelefonico = numTelefonico;
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipoProducto = tipoProducto;
    }



    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getCedulaRuc() {
        return cedulaRuc;
    }

    public void setCedulaRuc(int cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }

    public int getNumTelefonico() {
        return numTelefonico;
    }

    public void setNumTelefonico(int numTelefonico) {
        this.numTelefonico = numTelefonico;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


    public void insertarCliente(Cliente cliente) {
        (new ConexionDB()).insertarCliente(cliente);
    }

    public ArrayList<Cliente> getClientesPorCedula(int cedula) {
        return (new ConexionDB()).getClientesPorCedula(cedula);
    }
}
