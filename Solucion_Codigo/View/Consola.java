
package View;
import Model.Producto;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Consola {

    private Scanner scanner;
    private static final SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    public Consola() {
        this.scanner = new Scanner(System.in);
    }

    public Producto crearProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la categoria del producto:");
        String categoria = scanner.nextLine();

        System.out.println("Ingrese el precio normal del producto:");
        double precioNormal = scanner.nextDouble();

        System.out.println("Ingrese el precio promocional del producto:");
        double precioPromocional = scanner.nextDouble();

        System.out.println("Ingrese la cantidad en stock del producto:");
        int cantidadEnStock = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Ingrese la fecha de caducidad del producto (dd/MM/yyyy):");
        String fechaCaducidadStr = scanner.nextLine();
        Date fechaCaducidad = null;
        try {
            fechaCaducidad = fecha.parse(fechaCaducidadStr);
        } catch (ParseException e) {
        }

        return new Producto(nombre, categoria, precioNormal, precioPromocional, cantidadEnStock, fechaCaducidad);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}


