package clasesHijas.deReserva;
import clasesPadres.Reserva;
import ingresoSalida.Salida;
import clasesHijas.dePersona.Cliente;
import clasesHijas.deHabitacion.*;

public class ReservaBusiness extends Reserva {
    private String nombreEmpresa;
    private boolean salaConferencias;
   /* public int[] numerosUsados = getNumerosUsados();
    public static int cantidadNumerosUsados = getCantidadNumerosUsados();*/


    // Constructor
    public ReservaBusiness(String nombreEmpresa, Cliente cliente, String fechaIngreso, String fechaSalida, int cantPersonas, boolean salaConferencias ) {
        super(cliente, fechaIngreso, fechaSalida, cantPersonas);
        this.nombreEmpresa = nombreEmpresa;
        this.salaConferencias = salaConferencias;
    }

    public ReservaBusiness () {
        super();
        this.nombreEmpresa = "";
        this.salaConferencias = false; // Por defecto, no hay sala de conferencias
    }

    // Getters y Setters
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }

    public boolean getSalaConferencias() { return salaConferencias; }
    public void setsalaConferencias(boolean salaConferencias) { this.salaConferencias = salaConferencias; }

    // Método para mostrar información de la reserva business
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() +
         "\nTipo de Reserva:  BUSINESS " +
                "\nNombre Empresa: " + nombreEmpresa +
                "\nSala Conferencias: " + (salaConferencias ? "Sí" : "No");
    }
    @Override
    public void cargarReserva() {
        Salida.mMensaje("Cargue su reserva business", "Cargar Reserva Business");
        String datoSalaString = "";
        super.cargarReserva();
        this.nombreEmpresa = ingresoSalida.Ingreso.datoString("Ingrese el nombre de la empresa:", "Nombre Empresa", 1);
        boolean error = false;
        do { datoSalaString = ingresoSalida.Ingreso.datoString("¿Incluye sala de conferencias? (si/no):", "Sala Conferencias", 1);
            if (datoSalaString.equals("si")){
                error = true;
            }   
    } while(!error);
    this.salaConferencias = deSiONoABoolean(datoSalaString);
    //registrarNumero(getIdReserva());
    }
    
   /* public void registrarNumero(int numero) {
        if (cantidadNumerosUsados < numerosUsados.length) {
            numerosUsados[cantidadNumerosUsados] = numero;
            cantidadNumerosUsados++;
        } else {
            Salida.mError("Límite de reservas alcanzado.", "Error");
        }
    }*/
    @Override
    public void eliminarReserva() {
        super.eliminarReserva();
        this.nombreEmpresa = "";
        this.salaConferencias = false;
  
    }


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
    
}