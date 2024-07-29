package Modelo;

public abstract class Producto_Servicio {
    public String nombreProducto;
    public double precio;
    public int cantidad;
    public String Categoria;

    public Producto_Servicio(String nombreProducto, double precio, int cantidad, String Categoria) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.Categoria = Categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public abstract String getCategoria();
    public abstract double calcularDeducibles();

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Clases internas estáticas
    public static class Vivienda extends Producto_Servicio {
        public Vivienda(String nombreProducto, double precio, int cantidad) {
            super(nombreProducto, precio, cantidad, "Vivienda");
        }

        @Override
        public String getCategoria() {
            return "Vivienda";
        }

        @Override
        public double calcularDeducibles() {
            return getPrecio() * 0.10; // 10% de deducibles
        }
    }

    public static class Salud extends Producto_Servicio {
        public Salud(String nombreProducto, double precio, int cantidad) {
            super(nombreProducto, precio, cantidad, "Salud");
        }

        @Override
        public String getCategoria() {
            return "Salud";
        }

        @Override
        public double calcularDeducibles() {
            return getPrecio() * 0.08; // 8% de deducibles
        }
    }

    public static class Alimentacion extends Producto_Servicio {
        public Alimentacion(String nombreProducto, double precio, int cantidad) {
            super(nombreProducto, precio, cantidad, "Alimentacion");
        }

        @Override
        public String getCategoria() {
            return "Alimentacion";
        }

        @Override
        public double calcularDeducibles() {
            return getPrecio() * 0.07; // 7% de deducibles
        }
    }

    public static class Vestimenta extends Producto_Servicio {
        public Vestimenta(String nombreProducto, double precio, int cantidad) {
            super(nombreProducto, precio, cantidad, "Vestimenta");
        }

        @Override
        public String getCategoria() {
            return "Vestimenta";
        }

        @Override
        public double calcularDeducibles() {
            return getPrecio() * 0.05; // 5% de deducibles
        }
    }

    public static class Educacion extends Producto_Servicio {
        public Educacion(String nombreProducto, double precio, int cantidad) {
            super(nombreProducto, precio, cantidad, "Educacion");
        }

        @Override
        public String getCategoria() {
            return "Educacion";
        }

        @Override
        public double calcularDeducibles() {
            return getPrecio() * 0.12; // 12% de deducibles
        }
    }
}
