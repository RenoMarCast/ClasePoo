    package Practica2;

    public class ProductoDespensa {

        // ATRIBUTOS: son privados (encapsulamiento); solo se accede con getters y setters
        private String codigo;
        private String nombre;
        private String categoria;
        private byte cantidadDisponible; // cuántas piezas hay ahorita
        private byte cantidadMinima;     // mínimo que debe haber en la despensa
        private double precioUnitario;   // precio de una pieza

        // Constructor Vacio
        public ProductoDespensa() {
            this.codigo = " ";
            this.nombre = " ";
            this.categoria = "Alimento";
            this.cantidadDisponible = 0;
            this.cantidadMinima = 1;
            this.precioUnitario = 1.0;
        }

        // Constructo Con todos los datos
        // Usa los setters (no asigna directo) para que también se apliquen las validaciones
        public ProductoDespensa(String codigo, String nombre, String categoria,
        byte cantidadDisponible, byte cantidadMinima, double precioUnitario) {
            /*
            setCodigo(codigo);
            setNombre(nombre);
            setCategoria(categoria);
            setCantidadDisponible(cantidadDisponible);
            setCantidadMinima(cantidadMinima);
            setPrecioUnitario(precioUnitario);
             */
            this.codigo = codigo;
            this.nombre = nombre;
            this.categoria = categoria;
            this.cantidadDisponible = cantidadDisponible;
            this.cantidadMinima = cantidadMinima;
            this.precioUnitario = precioUnitario;
        }

        // SET modifican los atributos privados

        public void setCodigo(String codigo)
        {
            this.codigo = codigo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        // Solo acepta valores de 0 en adelante (no existen cantidades negativas)
        public void setCantidadDisponible(byte cantidadDisponible) {
            if (cantidadDisponible >= 0) {
                this.cantidadDisponible = cantidadDisponible;
            }
        }

        // Solo acepta valores mayores que 0 y menores que 20
        public void setCantidadMinima(byte cantidadMinima) {
            if (cantidadMinima > 0 && cantidadMinima < 20) {
                this.cantidadMinima = cantidadMinima;
            }
        }

        // Solo acepta precios mayores que 0
        public void setPrecioUnitario(double precioUnitario) {
            if (precioUnitario > 0) {
                this.precioUnitario = precioUnitario;
            }
        }

        // GETS: regresan el valor de cada atributo
        public String getCodigo() {
            return codigo;
        }

        // Metodo Negocio

        //necesita reabastecer si lo disponible es menor o igual al mínimo
        public boolean requiereReabastecimiento() {
            return cantidadDisponible <= cantidadMinima;
        }
        // Si no requiere reabastecimiento se queda en 0.
        public int calcularCantidadPorComprar() {
            int cantidad = 0;
            if (requiereReabastecimiento()) {
                int meta = cantidadMinima * 2;        // meta = el doble del mínimo
                cantidad = meta - cantidadDisponible; // lo que falta para llegar a la meta
            }
            return cantidad;
        }

        // Costo recomendado según la categoría:
        // Alimento = costo normal, Limpieza = +5 %, Higiene = +10 %.
        // Si no se necesita reabastecer, el costo es 0.
        public double calcularCostoRecomendado() {
            double costo = 0;
            if (requiereReabastecimiento()) {
                // costo base = piezas por comprar * precio de cada una
                costo = calcularCantidadPorComprar() * precioUnitario;
                // se le suma el recargo según la categoría
                if (categoria.equals("Limpieza")) {
                    costo = costo * 1.05;
                } else if (categoria.equals("Higiene")) {
                    costo = costo * 1.10;
                }
            }
            return costo;
        }

        // EL toStrinG regresa todos los datos en un texto para mostrarlos
        @Override
        public String toString() {
            return "Código: " + codigo + "\nNombre: " + nombre + "\nCategoría: " + categoria +
                    "\nCantidad disponible: " + cantidadDisponible + "\nCantidad mínima: " + cantidadMinima +
                    "\nPrecio unitario: $" + precioUnitario;
        }
    }