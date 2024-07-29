package Controlador;

import Modelo.Producto_Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Factura {
    private double subtotal;
    private double iva;
    private double total;
    private List<Producto_Servicio> productos;

    public Factura() {
        productos = new ArrayList<>();
    }

    // Método para añadir productos a la factura
    public void agregarProducto(Producto_Servicio producto) {
        productos.add(producto);
    }

    public void calcularTotales() {
        double subtotal = 0.0;

        // Calcular subtotal
        for (Producto_Servicio producto : productos) {
            subtotal += producto.getPrecio(); // O el atributo adecuado
        }

        // Calcular IVA y total
        double porcentajeIva = 0.15; // 15%
        double iva = subtotal * porcentajeIva;
        double total = subtotal + iva;

        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public ArrayList<Double> calcularDeducibles() {
    double montoVivienda = 0.0;
    double montoVestimenta = 0.0;
    double montoSalud = 0.0;
    double montoEducacion = 0.0;
    double montoAlimentacion = 0.0;

    for (Producto_Servicio producto : productos) {
        double deducible = producto.calcularDeducibles();
        String categoria = producto.getCategoria();
        
        switch (categoria) {
            case "Vivienda":
                montoVivienda += deducible;
                break;
            case "Vestimenta":
                montoVestimenta += deducible;
                break;
            case "Salud":
                montoSalud += deducible;
                break;
            case "Educacion":
                montoEducacion += deducible;
                break;
            case "Alimentacion":
                montoAlimentacion += deducible;
                break;
            default:
                // Manejar categorías no reconocidas si es necesario
                break;
        }
    }

    ArrayList<Double> deducibles = new ArrayList<>();
    deducibles.add(montoVivienda);
    deducibles.add(montoVestimenta);
    deducibles.add(montoSalud);
    deducibles.add(montoEducacion);
    deducibles.add(montoAlimentacion);

    return deducibles;
}



    

    // Getters
    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    public double getMontoVivienda() {
        return calcularDeducibles().get(0);
    }

    public double getMontoVestimenta() {
        return calcularDeducibles().get(1);
    }

    public double getMontoSalud() {
        return calcularDeducibles().get(2);
    }

    public double getMontoEducacion() {
        return calcularDeducibles().get(3);
    }

    public double getMontoAlimentacion() {
        return calcularDeducibles().get(4);
    }
public class FacturaControlador {
    private Factura factura;

    public FacturaControlador() {
        factura = new Factura();
    }

    public void calcularTotales(DefaultTableModel modeloTabla) {
        factura = new Factura();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String nombreProducto = (String) modeloTabla.getValueAt(i, 0);
            double precio = Double.parseDouble(modeloTabla.getValueAt(i, 7).toString());
            int cantidad = Integer.parseInt(modeloTabla.getValueAt(i, 5).toString());
            String categoria = (String) modeloTabla.getValueAt(i, 6);
            Producto_Servicio producto = new Producto_Servicio(nombreProducto, precio, cantidad, categoria) {
                @Override
                public String getCategoria() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }

                @Override
                public double calcularDeducibles() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
            factura.agregarProducto(producto);
        }

        factura.calcularTotales();
    }

    public String calcularDeducibles() {
        ArrayList<Double> deducibles = factura.calcularDeducibles();
        double totalDeducibles = 0.0;
        for (double deducible : deducibles) {
            totalDeducibles += deducible;
        }
        return String.format("%.2f", totalDeducibles);
    }

    public String getSubtotal() {
        return String.format("%.2f", factura.getSubtotal());
    }

    public String getIva() {
        return String.format("%.2f", factura.getIva());
    }

    public String getTotal() {
        return String.format("%.2f", factura.getTotal());
    }
}
}
