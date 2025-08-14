package clasesHijas.deReserva;
import clasesHijas.dePersona.Cliente;
import clasesPadres.Reserva;
import ingresoSalida.Salida;

public class ReservaIndividual extends Reserva {
    private boolean piscinaIncluida;
    /*public int[] numerosUsados = getNumerosUsados();
    public static int cantidadNumerosUsados = getCantidadNumerosUsados();*/
    // Constructor
    public ReservaIndividual( Cliente cliente, String fechaIngreso, String fechaSalida, int cantPersonas, boolean piscina) {
        super(cliente, fechaIngreso, fechaSalida, cantPersonas);
        this.piscinaIncluida = piscina; // Incrementa el contador de reservas
    }
    public ReservaIndividual () {
        super();
        this.piscinaIncluida = false; // Por defecto, no hay piscina incluida
    }
    
    // Getters y Setters

    public String getPiscina() {
        return piscinaIncluida ? "Sí" : "No";
    }


    @Override
    public void cargarReserva() {
        Salida.mMensaje("Cargue su reserva individual", "Cargar Reserva Individual");
        super.cargarReserva();
        String datoPiscina = "";
        boolean error = false;
        do {
         datoPiscina =ingresoSalida.Ingreso.datoString("¿Incluye piscina? (si/no):", "Piscina Incluida", 1);
        if (datoPiscina.equals("si")) {
            error = true;}
        }
        while (!error);
        this.piscinaIncluida = deSiONoABoolean(datoPiscina);
        
    }
@Override
    public String mostrarInfo() {
        return super.mostrarInfo() +
         "\nTipo de Reserva:  INDIVIDUAL " +
                 "\nPiscina Incluida: " + getPiscina();
    }
               

    @Override
    public void modificarReserva() {
        Salida.mMensaje("Modifique su reserva individual", "Modificar Reserva Individual");
        super.setCantPersonas(ingresoSalida.Ingreso.datoEntero("Ingrese la nueva cantidad de personas:", "Nueva Cantidad de Personas", 1));
        super.setFechaIngreso(ingresoSalida.Ingreso.datoString("Ingrese la nueva fecha de inicio de la reserva (dd/mm/yyyy):", "Nueva Fecha Inicio", 1));
        super.setFechaSalida(ingresoSalida.Ingreso.datoString("Ingrese la nueva fecha de fin de la reserva (dd/mm/yyyy):", "Nueva Fecha Fin", 1));
         boolean error = false;
         String datoPiscina = "";
        do { datoPiscina = ingresoSalida.Ingreso.datoString("¿Incluye piscina? (Si/no):", "Piscina Incluida", 1);
            if (datoPiscina.equals("si")) {
                error = true;}}
        while (!error );

        this.piscinaIncluida = deSiONoABoolean(datoPiscina);
        Salida.mMensaje("Reserva individual modificada exitosamente.", "Modificación Exitosa");
    }
    
    @Override
    public void eliminarReserva() {
        Salida.mMensaje("Elimine su reserva individual", "Eliminar Reserva Individual");
        super.eliminarReserva();
        this.piscinaIncluida = false; // Resetea el estado de la piscina al eliminar la reserva
        
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