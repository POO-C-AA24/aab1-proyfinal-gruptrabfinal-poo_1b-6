package Controler;

import Model.Factura;
import Model.Producto;
import View.Consola;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SuperMaxi {

    private List<Producto> inventario;
    private Factura factura;
    private Consola consola;
    private static final String INVENTARIO_FILE = "inventario.dat";
    private static final String FACTURA_FILE = "factura.dat";

    public SuperMaxi() {
        this.inventario = new ArrayList<>();
        this.factura = new Factura();
        this.consola = new Consola();
        cargarInventario();
    }

    public void agregarProducto() {
        Producto producto = consola.crearProducto();
        inventario.add(producto);
        consola.mostrarMensaje("Producto agregado exitosamente!");
        guardarInventario();
    }

    public void facturar() {
        for (Producto producto : inventario) {
            factura.agregarProducto(producto);
        }
        consola.mostrarMensaje("Total de la factura: " + factura.getTotal());
        guardarFactura();
    }

    public void mostrarInventario() {
        for (Producto producto : inventario) {
            consola.mostrarMensaje(producto.toString());
        }
    }

    private void cargarInventario() {
        try (ObjectInputStream Invent_ario = new ObjectInputStream(new FileInputStream(INVENTARIO_FILE))) {
            inventario = (List<Producto>) Invent_ario.readObject();
        } catch (FileNotFoundException e) {
            consola.mostrarMensaje("No se encontro, el archivo de inventario. Se creara¡ uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    private void guardarInventario() {
        try (ObjectOutputStream G_inventario = new ObjectOutputStream(new FileOutputStream(INVENTARIO_FILE))) {
            G_inventario.writeObject(inventario);
        } catch (IOException e) {
        }
    }

    private void guardarFactura() {
        try (ObjectOutputStream G_Factura = new ObjectOutputStream(new FileOutputStream(FACTURA_FILE))) {
            G_Factura.writeObject(factura);
        } catch (IOException e) {
        }
    }
}

    

