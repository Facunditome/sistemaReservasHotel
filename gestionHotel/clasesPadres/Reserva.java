package clasesPadres;


import javax.swing.JOptionPane;

import ingresoSalida.*;
import clasesHijas.dePersona.Cliente;

public class Reserva {
  /*  public static int[] numerosUsados = new int[100];
    public static int cantidadNumerosUsados = 0;*/

   
    private int idReserva;
    private String fechaIngreso;
    private String fechaSalida;
    private int cantPersonas;
    private Cliente cliente;
    private Habitacion habitacion;
    private static int contadorReservas= 0;

    // CONSTRUCTORES

    public Reserva(){
        contadorReservas++;
        this.idReserva = contadorReservas;
        this.fechaIngreso = "";
        this.fechaSalida = "";
        this.cantPersonas = 0;
        this.cliente= null; // inicializa null
        
         
    }
    
    public Reserva(Cliente cliente, String fechaIngreso, String fechaSalida, int cantPersonas) {
        contadorReservas++;
        this.idReserva = contadorReservas;

        this.cliente=cliente;
        this.fechaIngreso= fechaIngreso;
        this.fechaSalida= fechaSalida;
        this.cantPersonas= cantPersonas;

      // registrarNumero(idReserva);
    }
    
    // MÉTODOS
    /*private void registrarNumero(int numero) {
        if (cantidadNumerosUsados < numerosUsados.length) {
            numerosUsados[cantidadNumerosUsados] = numero;
            cantidadNumerosUsados++;
        } else {
            Salida.mError("Límite de habitaciones alcanzado.", "Error");
        }
    }*/

    public String mostrarInfo() {
        String datosDelCliente;
        String datosHabitacion= (habitacion != null) ? habitacion.mostrarInfo(): "Habitación no asignada";

        if (cliente != null) {
        datosDelCliente= cliente.mostrarInfo();
        } else {
            datosDelCliente= "Reserva sin datos de cliente";
        }
        return "ID Reserva: " + idReserva + "\n" +
               datosDelCliente + "\n" +
               "Habitacion: " + datosHabitacion + "\n" +               
               "Fecha de Ingreso: " + fechaIngreso + "\n" +
               "Fecha de Salida: " + fechaSalida + "\n" +
               "Cantidad de Personas: " + cantPersonas+ "\n";
    }


// método para cargar datos falta

// GET Y SET 
    public void confirmar () {
        JOptionPane.showMessageDialog(null , "Reserva confirmada");
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    /*public static int[] getNumerosUsados() {
        return numerosUsados;
    }
    public static int getCantidadNumerosUsados() {
        return cantidadNumerosUsados;
    }*/

     public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
    public int getContadorReservas() {
        return contadorReservas;
    }

    public void setContadorReservas(int contadorReservas) {
        this.contadorReservas = contadorReservas;
    }

    // Método 
    public void cargarReserva(){
        //boolean valido;
         /*do {
            valido = true;
             num = Ingreso.datoEntero("Ingrese el ID de la reserva:", "ID Reserva", 1);
            if (numeroYaUsado(num)) {
                Salida.mError("Ese número de habitación ya está en uso.", "Número duplicado");
                valido = false;
                
            }}
            while (!valido);*/

       // registrarNumero(idReserva);
        this.fechaIngreso = Ingreso.datoString("Ingrese la fecha de inicio de la reserva (dd/mm/yyyy):", "Fecha Inicio", 1);
        this.fechaSalida = Ingreso.datoString("Ingrese la fecha de fin de la reserva (dd/mm/yyyy):", "Fecha Fin", 1);
        this.cantPersonas = Ingreso.datoEntero("Ingrese la cantidad de personas:", "Cantidad de Personas", 1);
    }
  /*  private boolean numeroYaUsado(int numero) {
        for (int i = 0; i < cantidadNumerosUsados; i++) {
            if (numerosUsados[i] == numero) {
                return true;
            }
        }
        return false;
        
        }*/
    public void eliminarReserva() {
        this.idReserva = 0;
        this.fechaIngreso = "";
        this.fechaSalida = "";
        this.cantPersonas = 0;
    }
    public void modificarReserva() {
        this.fechaIngreso = Ingreso.datoString("Ingrese la nueva fecha de inicio de la reserva (dd/mm/yyyy):", "Nueva Fecha Inicio", 1);
        this.fechaSalida = Ingreso.datoString("Ingrese la nueva fecha de fin de la reserva (dd/mm/yyyy):", "Nueva Fecha Fin", 1);
        this.cantPersonas = Ingreso.datoEntero("Ingrese la nueva cantidad de personas:", "Nueva Cantidad de Personas", 1);
}
    public Cliente getClientes() {
    return this.cliente;
}

    public void setCliente(Cliente cliente) {
        this.cliente= cliente;
    }
}
 




