package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura implements Serializable{

    private List<Producto> productos;
    private double total;

    public Factura() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        if (producto.getCantidadEnStock() > 0 && producto.getFechaCaducidad().after(new Date())) {
            this.total += producto.getPrecioNormal();
        } else {
            this.total += producto.getPrecioPromocional();
        }
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "productos=" + productos +
                ", total=" + total +
                '}';
    }
}

