
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Producto implements Serializable{

    private String nombre;
    private String categoria;
    private double precioNormal;
    private double precioPromocional;
    private int cantidadEnStock;
    private Date fechaCaducidad;
    
    private static final SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    public Producto(String nombre, String categoria, double precioNormal, double precioPromocional, int cantidadEnStock, Date fechaCaducidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioNormal = precioNormal;
        this.precioPromocional = precioPromocional;
        this.cantidadEnStock = cantidadEnStock;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPrecioPromocional() {
        return precioPromocional;
    }

    public void setPrecioPromocional(double precioPromocional) {
        this.precioPromocional = precioPromocional;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precioNormal=" + precioNormal +
                ", precioPromocional=" + precioPromocional +
                ", cantidadEnStock=" + cantidadEnStock +
                ", fechaCaducidad=" + fecha.format(fechaCaducidad) +
                '}';
    }
    
}

