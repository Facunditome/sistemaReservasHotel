package clasePrincipal;

import clasesHijas.deHabitacion.HabitacionEconomica;
import clasesHijas.deHabitacion.HabitacionPremium;
import clasesHijas.dePersona.Cliente;
import clasesHijas.dePersona.Empleado;
import clasesHijas.deReserva.ReservaBusiness;
import clasesHijas.deReserva.ReservaIndividual;
import clasesPadres.Habitacion;
import clasesPadres.Reserva;
import ingresoSalida.*;

public class Hotel {

    private Cliente[] clientes = new Cliente[200];
    private Habitacion[] habitaciones = new Habitacion[40];
    private Reserva[] reservas = new Reserva[50];
    private Empleado[] empleados = new Empleado[50];
    private HabitacionEconomica[] habitacionesEconomicas = new HabitacionEconomica[20];
    private HabitacionPremium[] habitacionesPremium = new HabitacionPremium[20];
    private ReservaBusiness[] reservaBusinesses = new ReservaBusiness[10];
    private ReservaIndividual[] reservaIndividuals = new ReservaIndividual[10];

    private String nombre; // Nombre del hotel
    private String contrasena = "";
    private int cantClientes = 0;
    private int cantHabitaciones = 0;
    private int cantHabitacionesEconomicas = 0;
    private int cantHabitacionesPremium = 0;
    private int cantReservas = 0;
    private int cantEmpleados = 0;
    private int cantReservaBusinesses = 0;
    private int cantReservaIndividual = 0;

    // Constructor
    public Hotel() {

    }

    public Hotel(Cliente[] clientes, Habitacion[] habitaciones, Reserva[] reservas, Empleado[] empleados,
            HabitacionEconomica[] habitacionesEconomicas, HabitacionPremium[] habitacionesPremium, String contrasena,
            ReservaBusiness[] reservaBusinesses, ReservaIndividual[] reservaIndividuals) {
        this.clientes = clientes;
        this.habitaciones = habitaciones;
        this.reservas = reservas;
        this.empleados = empleados;
        this.habitacionesEconomicas = habitacionesEconomicas;
        this.habitacionesPremium = habitacionesPremium;
        this.contrasena = contrasena;
        this.cantClientes = clientes.length;
        this.cantHabitaciones = habitaciones.length;
        this.cantHabitacionesEconomicas = habitacionesEconomicas.length;
        this.cantHabitacionesPremium = habitacionesPremium.length;
        this.cantReservas = reservas.length;
        this.cantEmpleados = empleados.length;
        this.reservaIndividuals = reservaIndividuals;
        this.reservaBusinesses = reservaBusinesses;
        this.cantReservaBusinesses = reservaBusinesses.length;
        this.cantReservaIndividual = reservaIndividuals.length;
    }

    public Hotel(String contrasena) {
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Reserva[] getReservas() {
        return this.reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public int getCantClientes() {
        return cantClientes;
    }

    public void setCantClientes(int cantClientes) {
        this.cantClientes = cantClientes;
    }

    public int getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }

    public int getCantHabitacionesEconomicas() {
        return cantHabitacionesEconomicas;
    }

    public void setCantHabitacionesEconomicas(int cantHabitacionesEconomicas) {
        this.cantHabitacionesEconomicas = cantHabitacionesEconomicas;
    }

    public int getCantHabitacionesPremium() {
        return cantHabitacionesPremium;
    }

    public void setCantHabitacionesPremium(int cantHabitacionesPremium) {
        this.cantHabitacionesPremium = cantHabitacionesPremium;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public int getCantReservaBusinesses() {
        return cantReservaBusinesses;
    }

    public void setCantReservaBusinesses(int cantReservaBusinesses) {
        this.cantReservaBusinesses = cantReservaBusinesses;
    }

    public int getCantReservaIndividual() {
        return cantReservaIndividual;
    }

    public void setCantReservaIndividual(int cantReservaIndividual) {
        this.cantReservaIndividual = cantReservaIndividual;
    }

    public boolean altaCli(Cliente nuevo) { // este método corrobora que exista lugar y no exista dni repetido
        if (cantClientes >= clientes.length) { // corrobora que exista lugar en el hotel
            return false;
        }

        for (int i = 0; i < cantClientes; i++) { // busca que no haya dni repetido
            if (clientes[i].getDni().equals(nuevo.getDni())) {
                return false;
            }
        }

        clientes[cantClientes++] = nuevo; // actualiza el contador
        return true;

    }

    public void inizializarHabs() {

        altaHabitacionEconomica(new HabitacionEconomica(1, 15000, 1, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(2, 15000, 1, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(3, 17000, 2, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(4, 17000, 2, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(5, 20000, 3, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(6, 20000, 3, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(7, 22000, 4, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(8, 22000, 4, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(9, 24000, 5, true, true, false));
        altaHabitacionEconomica(new HabitacionEconomica(10, 24000, 5, true, true, false));

        altaHabitacionPremium(new HabitacionPremium(11, 30000, 1, true, true));
        altaHabitacionPremium(new HabitacionPremium(12, 30000, 1, true, true));
        altaHabitacionPremium(new HabitacionPremium(13, 34000, 2, true, true));
        altaHabitacionPremium(new HabitacionPremium(14, 34000, 2, true, true));
        altaHabitacionPremium(new HabitacionPremium(15, 38000, 3, true, true));
        altaHabitacionPremium(new HabitacionPremium(16, 38000, 3, true, true));
        altaHabitacionPremium(new HabitacionPremium(17, 40000, 4, true, true));
        altaHabitacionPremium(new HabitacionPremium(18, 40000, 4, true, true));
        altaHabitacionPremium(new HabitacionPremium(19, 45000, 5, true, true));
        altaHabitacionPremium(new HabitacionPremium(20, 45000, 5, true, true));
    }

    public boolean altaHabitacionPremium(HabitacionPremium nuevo) { // este método corrobora que exista lugar y no
                                                                    // exista dni repetido
        if (cantHabitacionesPremium >= habitacionesPremium.length) { // corrobora que exista lugar en el hotel
            return false;
        }

        for (int i = 0; i < cantHabitacionesPremium; i++) { // busca que no haya dni repetido
            if (habitacionesPremium[i].getNumero() == (nuevo.getNumero())) {
                return false;
            }

        }
        habitacionesPremium[cantHabitacionesPremium++] = nuevo; // actualiza el contador
        return true;
    }

    public boolean altaHabitacionEconomica(HabitacionEconomica nuevo) { // este método corrobora que exista lugar y no
                                                                        // exista dni repetido
        if (cantHabitacionesEconomicas >= habitacionesEconomicas.length) { // corrobora que exista lugar en el hotel
            return false;
        }
        for (int i = 0; i < cantHabitacionesEconomicas; i++) { // busca que no haya dni repetido
            if (habitacionesEconomicas[i].getNumero() == (nuevo.getNumero())) {
                return false;
            }

        }
        habitacionesEconomicas[cantHabitacionesEconomicas++] = nuevo; // actualiza el contador
        return true;
    }

    public boolean altaHabitacion(Habitacion nuevo) { // este método corrobora que exista lugar y no exista dni repetido
        if (cantHabitaciones >= habitaciones.length) { // corrobora que exista lugar en el hotel
            return false;
        }

        for (int i = 0; i < cantHabitaciones; i++) { // busca que no haya dni repetido
            if (habitaciones[i].getNumero() == (nuevo.getNumero())) {
                return false;
            }

        }
        habitaciones[cantHabitaciones++] = nuevo; // actualiza el contador
        return true;

    }

    public Cliente buscarClienteDni(String dni) {
        for (int i = 0; i < cantClientes; i++) { // recorro la lista de clientes
            if (clientes[i].getDni().equalsIgnoreCase(dni)) { // comparo con dni para saber si existe
                Salida.mConfirmacion("Cliente: " + clientes[i].mostrarInfo(), "Muestra cliente");
                return clientes[i];
            }
        }
        Salida.mError("Cliente no encontrado", "Error");
        return null;
    }

    public void agregarReserva(Reserva nuevaReserva) {
        if (cantReservas < reservas.length) { // para saber si hay lugar
            reservas[cantReservas] = nuevaReserva; // agregamos la reserva
            cantReservas++;
        } else {
            Salida.mAdvertencia("No hay mas reservas disponibles", "Todo ocupado");
        }
    }

    public boolean altaReservaIndividual(Reserva resInd) {
        if (cantReservaIndividual >= reservaIndividuals.length) {
            return false;
        }
        for (int i = 0; i < cantReservaIndividual; i++) {
            if (reservaIndividuals[i].getIdReserva() == (resInd.getIdReserva())) {
                return false;
            }

        }
        reservaIndividuals[cantReservaIndividual++] = (ReservaIndividual) resInd; // actualiza el contador
        agregarReserva(resInd);
        return true;
    }

    public boolean altaReservaBusinesses(Reserva resBus) {
        if (cantReservaBusinesses >= reservaBusinesses.length) {
            return false;
        }
        for (int i = 0; i < cantReservaBusinesses; i++) {
            if (reservaBusinesses[i].getIdReserva() == (resBus.getIdReserva())) {
                return false;
            }
        }
        reservaBusinesses[cantReservaBusinesses++] = (ReservaBusiness) resBus;
        agregarReserva(resBus);
        return true;
    }

    public void mostrarReservas() {
        if (cantReservas == 0) {
            Salida.mMensaje("No existen reservas", "No hay reservas");
        } else {
            for (int i = 0; i < cantReservas; i++) {
                Salida.mMensaje(reservas[i].mostrarInfo(), "Muestra las reservas");
            }
        }
    }

    public void mostrarHabitaciones() {
        if (cantHabitaciones == 0 && cantHabitacionesEconomicas == 0 && cantHabitacionesPremium == 0) {
            Salida.mMensaje("No hay habitaciones cargadas en el sistema.", "Habitaciones vacías");

        }

        boolean hayDisponibles = false;

        for (int i = 0; i < cantHabitaciones; i++) {
            if (habitaciones[i] != null && habitaciones[i].isDisponible()) {
                Salida.mMensaje(habitaciones[i].mostrarInfo(), "Habitaciones disponibles");
                hayDisponibles = true;
            }
        }
        for (int i = 0; i < cantHabitacionesPremium; i++) {
            if (habitacionesPremium[i] != null && habitacionesPremium[i].isDisponible()) {
                Salida.mMensaje(habitacionesPremium[i].mostrarInfo(), "Habitaciones Premium disponibles");
                hayDisponibles = true;
            }
        }
        for (int i = 0; i < cantHabitacionesEconomicas; i++) {
            if (habitacionesEconomicas[i] != null && habitacionesEconomicas[i].isDisponible()) {
                Salida.mMensaje(habitacionesEconomicas[i].mostrarInfo(), "Habitaciones Economicas disponibles");
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            Salida.mMensaje("No hay habitaciones disponibles en este momento.", "Ocupado");
        }
    }

    public void verMiReserva() {
        String ingreso = Ingreso.datoString("Ingrese su DNI para consultar su reserva", "Consultar reserva", 1);

        // 1. Buscar el cliente
        Cliente cliente = buscarClienteDni(ingreso);

        if (cliente == null) {
            Salida.mError("No se encontró ningún cliente con ese DNI.", "Cliente no encontrado");
            return;
        }

        // 2. Buscar reservas asociadas
        boolean reservaEncontrada = false;

        for (int i = 0; i < cantReservas; i++) {
            Reserva r = reservas[i];
            if (r != null && r.getClientes() != null) {
                Salida.mMensaje(r.mostrarInfo(), "Reserva encontrada");
            }
        }

        if (!reservaEncontrada) {
            Salida.mError("No se encontró ninguna reserva asociada a ese cliente.", "Reserva no encontrada");
        }
    }

    public void mostrarClientes() {
        if (cantClientes == 0) {
            Salida.mMensaje("No existen clientes ingresados", "Existencia clientes");
        } else {
            for (int i = 0; i < cantClientes; i++) {
                Salida.mMensaje(clientes[i].mostrarInfo(), "Muestra clientes");
            }
        }
    }

    public void agregarCliente(Cliente cliente) { // metodo para agregar cliente desde el main
        if (cantClientes < clientes.length) {
            clientes[cantClientes] = cliente;
            cantClientes++;
        } else {
            Salida.mMensaje("Lo sentimos. No se pueden agregar mas clientes.", "Espacio clientes lleno");
        }

    }

    public boolean buscarDni(String ingreso) {
        for (int i = 0; i < cantClientes; i++) {
            if (clientes[i].getDni().equals(ingreso)) {
                Salida.mMensaje("Cliente encontrado", "Busco dni");
                return true;
            }
        }
        return false;
    }

    public Reserva buscarReserva(int id) {
        Reserva[] reservas2 = getReservas();
        for (int i = 0; i < cantReservas; i++) {
            if (reservas2[i].getIdReserva() == id) {
                return reservas2[i]; // Reserva encontrada
            }
        }
        Salida.mError("Reserva no encontrada", "Error");
        return null; // si es que no encuentra
    }

    public void eliminarReserva(int id) {
        Reserva reserva = buscarReserva(id);
        if (reserva != null) {
            for (int i = 0; i < cantReservas; i++) {
                if (reservas[i].getIdReserva() == id) {
                    reservas[i] = null; // Elimina la reserva
                    cantReservas--;
                    Salida.mMensaje("Reserva eliminada exitosamente.", "Eliminación Exitosa");
                    return;
                }
            }
        } else {
            Salida.mError("Reserva no encontrada.", "Error de Eliminación");
        }
    }

    public Cliente modificarDatosCliente(String dni) {
        Cliente cliente = buscarClienteDni(dni);
        if (cliente != null) {
            String nuevoNombre = Ingreso.datoString("Ingrese el nuevo nombre:", "Modificar Cliente", 1);
            String nuevoApellido = Ingreso.datoString("Ingrese el nuevo apellido:", "Modificar Cliente", 1);
            cliente.setNombre(nuevoNombre);
            cliente.setApellido(nuevoApellido);
            String nuevoEmail = Ingreso.datoString("Ingrese el nuevo email:", "Modificar Cliente", 1);
            String nuevoTelefono = Ingreso.datoString("Ingrese el nuevo teléfono:", "Modificar Cliente", 1);
            Salida.mMensaje("Datos del cliente modificados exitosamente.", "Modificación Exitosa");
            return cliente;
        } else {
            Salida.mError("Cliente no encontrado.", "Error de Modificación");
            return null;
        }
    }

    public void altaEmpleado(Empleado nuevo) {
        if (cantEmpleados < empleados.length) { // corrobora que exista lugar en el hotel
            empleados[cantEmpleados++] = nuevo; // actualiza el contador
        } else {
            Salida.mAdvertencia("No hay mas empleados disponibles", "Todo ocupado");
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        if (cantEmpleados < empleados.length) {
            empleados[cantEmpleados] = empleado;
            cantEmpleados++;
        } else {
            Salida.mMensaje("Lo sentimos. No se pueden agregar mas empleados.", "Espacio empleados lleno");
        }
    }

    public void mostrarEmpleados() {
        if (cantEmpleados == 0) {
            Salida.mMensaje("No existen empleados ingresados", "Existencia empleados");
        } else {
            for (int i = 0; i < cantEmpleados; i++) {
                Salida.mMensaje(empleados[i].mostrarInfo(), "Muestra empleados");
            }
        }
    }

    public Empleado buscarEmpleado(String ingreso) {
        for (int i = 0; i < cantEmpleados; i++) {
            if (empleados[i].getDni().equals(ingreso)) {
                Salida.mMensaje("Empleado encontrado", "Buscar empleado");
                return empleados[i];
            }
        }
        Salida.mError("No existe un empleado con ese DNI", "Ingreso empleado mal");
        return null; // Si no se encuentra el empleado, retorna null
    }

    public void ordenarClientes() {
        if (cantClientes == 0) {
            Salida.mMensaje("No hay clientes cargados.", "Sin clientes");
            return;
        }

        // Ordenamiento burbuja por apellido
        for (int i = 0; i < cantClientes - 1; i++) {
            for (int j = 0; j < cantClientes - i - 1; j++) {
                if (clientes[j].getApellido().compareToIgnoreCase(clientes[j + 1].getApellido()) > 0) {
                    // Intercambio
                    Cliente temp = clientes[j];
                    clientes[j] = clientes[j + 1];
                    clientes[j + 1] = temp;
                }
            }
        }
        // Mostramos los clientes ordenados
        // decidimos que lo haga solo con un mensaje porque sino eran muchos mensajes
        // uno atras del otro. Quizás no sea
        // lo mas optimo cuando hay muchos clientes, pero para este caso es suficiente.
        String resultado = "Clientes ordenados por apellido:\n";
        for (int i = 0; i < cantClientes; i++) {
            resultado += clientes[i].mostrarInfo() + "\n\n";
        }
        Salida.mMensaje(resultado, "Listado ordenado");
    }

    public Habitacion buscarHabitacionDisponibleEconomica(int cantPersonas) {
        for (int i = 0; i < cantHabitacionesEconomicas; i++) {
            if (habitacionesEconomicas[i].isDisponible() && habitacionesEconomicas[i].getLugares() >= cantPersonas) {
                return habitacionesEconomicas[i];
            }
        }
        return null;
    }

    public Habitacion buscarHabitacionDisponiblePremium(int cantPersonas) {
        for (int i = 0; i < cantHabitacionesPremium; i++) {
            if (habitacionesPremium[i].isDisponible () && habitacionesPremium[i].getLugares() >= cantPersonas) {
                return habitacionesPremium[i];
            }
        }
        return null;
    }

    public boolean lugaresDisponiblesHab(int tipoHabitacion) {
        if (tipoHabitacion == 1) {
            return cantHabitacionesEconomicas > 0;
        } else {
            return cantHabitacionesPremium > 0;
        }
    }

}
