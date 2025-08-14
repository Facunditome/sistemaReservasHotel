package clasesPadres;
import ingresoSalida.*;
public class Habitacion {
    private int numero;
    private double precio;
    private boolean disponible;
    private static int[] numerosUsados = new int[100];
    private static int cantidadNumerosUsados = 0;
    private int lugares;
    // Constructor
    public Habitacion(int numero, double precio, int lugares) {
        this.numero = numero;
        this.precio = precio;
        this.disponible = true; // Por defecto disponible
        this.lugares = lugares; // Inicializar con 0 lugares
        registrarNumero(numero);
    }

    public Habitacion() {
        this.numero = 0;
        this.precio = 0.0;
        this.disponible = true;
        this.lugares = 0; // Inicializar con 0 lugares
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getLugares() {
        return lugares;
    }

    public void setlugares(int lugares) {
        this.lugares = lugares;
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Cambiar estado
    public void cambiarEstado() {
        this.disponible = !this.disponible;
    }

   
    public String mostrarInfo() {
        String estado = disponible ? "Disponible" : "Ocupada";
        return "Habitación Nº " + numero +
               "\nPrecio: $" + precio +
               "\nEstado: " + estado;
    }

    // Método para crear una habitación usando inAndOut
    public void cargarHabitacion() {
        int num = 0; // Inicializar num
        double preciox;
        try {
            boolean valido = false;
        do {
            valido = true;
             num = Ingreso.datoEntero("Ingrese el número de la habitación:" , "Número de Habitación", 1);
            if (numeroYaUsado(num)) {
                Salida.mError("Ese número de habitación ya está en uso.", "Número duplicado");
                valido = false;
            }}
            while (!valido);
            // Si el número es válido, se procede a cargar el resto de los datos
            preciox = Ingreso.datoDoble("Ingrese el precio", "precio", 1);
            this.numero = num;
            this.precio = preciox;
            this.lugares = Ingreso.datoEntero("Ingrese la cantidad de lugares en la habitación:", "Cantidad de lugares", 1);
        } catch (NumberFormatException e) {
            Salida.mError("Error: Ingrese valores numéricos válidos para número o precio.", "Error");
        } catch (Exception e) {
            Salida.mError("Error inesperado: " + e.getMessage(), "Error");
        }
    }

    public void registrarNumero(int numero) {
        if (cantidadNumerosUsados < numerosUsados.length) {
            numerosUsados[cantidadNumerosUsados] = numero;
            cantidadNumerosUsados++;
        } else {
            Salida.mError("Límite de habitaciones alcanzado.", "Error");
        }
    }
    private boolean numeroYaUsado(int numero) {
        for (int i = 0; i < cantidadNumerosUsados; i++) {
            if (numerosUsados[i] == numero) {
                return true;
            }
        }
        return false;
    }

    // Conversor Si/No a booleano
    public boolean deSiONoABoolean(String m) {
        switch (m.toLowerCase()) {
            case "si":
                return true;
            case "no":
                return false;
            default:
                Salida.mError("Entrada inválida. Por favor, ingrese 'si' o 'no'.", "Error de Entrada");
                return false;
        }
    }
    public boolean laRespuestaFueSiONo(String respuesta) {
        return respuesta.toLowerCase().equalsIgnoreCase("si") || respuesta.toLowerCase().equalsIgnoreCase("no");
    }  
}



