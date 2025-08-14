package menuInteractivo;
import javax.swing.JOptionPane;
import clasePrincipal.Hotel;
import clasesHijas.deHabitacion.HabitacionEconomica;
import clasesHijas.deHabitacion.HabitacionPremium;
import clasesHijas.dePersona.Cliente;
import clasesHijas.dePersona.Empleado;
import clasesHijas.deReserva.ReservaBusiness;
import clasesHijas.deReserva.ReservaIndividual;
import clasesPadres.Habitacion;
import clasesPadres.Reserva;
import ingresoSalida.*;

public class main {

    public static void main(String[] args) {
        Hotel hotelLasFlores = new Hotel("admin"); //contraseña del hotel, IMPORTANTE
        boolean salir = false;  
        hotelLasFlores.setNombre("Las Flores"); 
        hotelLasFlores.inizializarHabs();

        /*---------------------------------------------------------------------------------------------*/

                                        // MENÚ EMPLEADO 
                              // ACA PUEDE AGREGAR NUEVOS CLIENTES 
       
        Cliente mf456= new Cliente ("Micaela", "Fernandez", "36123456", "1530843085", "micaelaFer@gmail.com"); 
        hotelLasFlores.agregarCliente(mf456);

                             // ACA PUEDE AGREGAR UNA RESERVA BUSINESSES
        hotelLasFlores.altaReservaBusinesses(new ReservaBusiness("Marianos", mf456, "10/08/2025", "12/08/2025", 2, true));

                             //ACA PUEDE AGREGAR UNA RESERVA INDIVIDUAL
        hotelLasFlores.altaReservaIndividual(new ReservaIndividual(mf456, "25/09/2025", "30/09/2025", 1, true));


                              // ACA PUEDE AGREGAR NUEVOS EMPLEADOS 
        hotelLasFlores.agregarEmpleado(new Empleado ("Juan", "Reverdito", "22527237", "Administrativo", 15256));

                            // ACA PUEDE AGREGAR NUEVAS HABITACIONES ECONOMICAS
        hotelLasFlores.altaHabitacionEconomica(new HabitacionEconomica(30, 50000, 8, true, false, false));


                             // ACA PUEDE AGREGAR NUEVAS HABITACIONES PREMIUM
        hotelLasFlores.altaHabitacionPremium(new HabitacionPremium(40, 80000, 10, true, true));


    
                            
        /*-----------------------------------------------------------------------------------------------*/

        

         
        // Menu principal
        while (!salir) {
            int rol = seleccionaRol(); // devuelve cliente o empleado
            switch (rol) {
                case 1:
                    salir = menuCliente(hotelLasFlores);
                    break;
                case 2:
                    salir = menuEmpleado(hotelLasFlores);
                    break;
                case 3:
                    salir = true;
                    Salida.mMensaje("Gracias por visitarnos.", "Hotel " + hotelLasFlores.getNombre() + " .");
                    break;
                default:
                    Salida.mAdvertencia("Opción inválida", null);
                    break;
            }
        }

    }

    private static int seleccionaRol() {
        // Muestra un menú para seleccionar el rol del usuario
        // Devuelve 1 para Cliente, 2 para Empleado, 3 para Salir
        String seleccionarRol = "Seleccione una de las opciones según corresponda";
        seleccionarRol += "\n1. Cliente";
        seleccionarRol += "\n2. Empleado";
        seleccionarRol += "\n3. Salir";

        int rol = Ingreso.datoEntero(seleccionarRol, "Menu opción", 1);
        return rol;
    }

    private static boolean menuCliente(Hotel hotelLasFlores) {
        // Muestra un menú para el cliente
        // Devuelve true si el cliente quiere salir, false si quiere seguir operando
        int opcion;
        String mensajeBv;
        mensajeBv = "Bienvenido al menú cliente";
        mensajeBv += "\n1. Hacer una Reserva";
        mensajeBv += "\n2. Ver mi reserva";
        mensajeBv += "\n3. Cancelar mi reserva";
        mensajeBv += "\n4. Salir";

        JOptionPane.showMessageDialog(null, mensajeBv);
        opcion = Ingreso.datoEntero("Ingrese la opción deseada", "Mensaje opción", 1);
        switch (opcion) {
            case 1:
                return altaDeRes(hotelLasFlores);
            case 2:
                return buscarReserva(hotelLasFlores);
            case 3:
                return cancelarReserva(hotelLasFlores);
            case 4:
                Salida.mMensaje("Gracias por su visita", "Hotel " + hotelLasFlores.getNombre() + " .");
                return true; // aca terminaria

          
            default:
                JOptionPane.showMessageDialog(null, "Debe ingresar una opción correcta.");
                return false; // aca vuelve a ejecutar
        }
    }

    private static boolean menuReservaHabitacion(Hotel hotelLasFlores) {
        // Muestra un menú para reservar habitaciones
        // Devuelve true si el cliente quiere salir, false si quiere seguir operando
        int opcion;
        String mensajeBv;
        mensajeBv = "Bienvenido al menú de reservas de habitaciones";
        mensajeBv += "\n1. Reservar Habitación premium";
        mensajeBv += "\n2. Reservar Habitación economica";
        mensajeBv += "\n3. salir";
        opcion = Ingreso.datoEntero(mensajeBv, "Menu opción", 1);
        switch (opcion) {
            case 1:
                return altaDeHabPremium(hotelLasFlores);
            case 2:
                return altaDeHabEconomica(hotelLasFlores);
            case 3:
                Salida.mMensaje("Gracias por su visita", "Hotel " + hotelLasFlores.getNombre() + " .");

                return true; // aca terminaria
            default:
                Salida.mMensaje("Debe ingresar una opción correcta", "Mal ingresado");
                return false; // aca vuelve a ejecutar
        }
        
    }
    private static boolean menuEmpleado(Hotel hotelLasFlores) {
        // Muestra un menú para el empleado
        // Devuelve true si el empleado quiere salir, false si quiere seguir operando
        // la contraseña del hotel es "admin" porque la inicializamos en el constructor del hotel
        boolean conrtaseñaCorrecta = false;
        String contraseñaIngresada = ""; 
        do {
            contraseñaIngresada = Ingreso.datoString("Ingrese la contraseña del hotel:", "Ingreso de contraseña", 1);
            if (validarContrasena(hotelLasFlores, contraseñaIngresada)) {
                conrtaseñaCorrecta = true; // si la contraseña es correcta, salimos del bucle
            } else {
                Salida.mError("Contraseña incorrecta. Intente nuevamente.", "Error de contraseña");
            }
        } while (!conrtaseñaCorrecta);
        int opcion;
        String mensajeBv;
        mensajeBv = "Bienvenido";
        mensajeBv += "\n1. Alta de Cliente";
        mensajeBv += "\n2. Alta de Habitación";
        mensajeBv += "\n3. Alta de Reserva";
        mensajeBv += "\n4. Lista Clientes";
        mensajeBv += "\n5. Lista Habitaciones";
        mensajeBv += "\n6. Lista de Reservas";
        mensajeBv += "\n7. Modificar datos de Clientes";
        mensajeBv += "\n8. Buscar Clientes por DNI";
        mensajeBv += "\n9. Ordenar Clientes por apellido";
        mensajeBv += "\n10. Buscar Reserva";
        mensajeBv += "\n11. Cancelar Reserva";
        mensajeBv += "\n12  Alta de Empleado";
        mensajeBv += "\n13. Mostrar Empleados";
        mensajeBv += "\n14. Buscar Empleados";
        mensajeBv += "\n15. Salir.";

        JOptionPane.showMessageDialog(null, mensajeBv);
        opcion = Ingreso.datoEntero("Ingrese la opción deseada", "Opción", 1);
        switch (opcion) {
            case 1:
                return altaDeCliente(hotelLasFlores);
            case 2:
                return menuReservaHabitacion(hotelLasFlores);
            case 3:
                return altaDeRes(hotelLasFlores);
            case 4:
                return listaClientes(hotelLasFlores);
            case 5:
                return listaHabitaciones(hotelLasFlores);
            case 6:
                return listaDeReservas(hotelLasFlores);
            case 7:
                return modificarDatosClientes(hotelLasFlores);
            case 8:
                return buscarClientesDni(hotelLasFlores);
            case 9: 
                return ordenarClientes(hotelLasFlores);
            case 10:
                return buscarReserva(hotelLasFlores);
            case 11:
                return cancelarReserva(hotelLasFlores);
            case 12: 
                return altaEmpleado(hotelLasFlores);      
            case 13:
                return mostrarEmpleados(hotelLasFlores); 
            case 14: 
                return buscarEmpleados(hotelLasFlores);
            case 15:
               Salida.mMensaje("Gracias por su visita", "Hotel " + hotelLasFlores.getNombre() + " .");
                return true; // aca terminaria
            default:
                Salida.mMensaje("Debe ingresar una opción correcta", "Mal ingresado");
                return false; // aca vuelve a ejecutar
        }
    }

    private static boolean altaDeCliente(Hotel hotelLasFlores) {
        
        Cliente cliente = new Cliente(); // creamos el cliente
        cliente.cargarInfo();
        // una vez que se crea el cliente se lo pasas al hotel
        boolean agregado = hotelLasFlores.altaCli(cliente);
        if (agregado) { // si lo agrega confirma por mensaje
            Salida.mConfirmacion("Cliente agregado", "Confirmación");
        } else {
            Salida.mAdvertencia("No se ha creado un nuevo cliente ya que se encontraba registrado..", "Advertencia");

        }
        return false;

    }

    private static boolean altaDeHab(Hotel hotelLasFlores) {
        Habitacion habitacion = new Habitacion(); // creamos la habitacion
        habitacion.cargarHabitacion();
        // una vez que se crea la habitacion se lo pasas al hotel
        boolean agregado = hotelLasFlores.altaHabitacion(habitacion);
        if (agregado) { // si lo agrega confirma por mensaje
            Salida.mConfirmacion("Habitación agregada", "Confirmación");
        } else {
            Salida.mConfirmacion("No se ha creado una nueva habitación ya que se encontraba registrada..", "Confirmación");

        }
        return false;
    }
    private static boolean altaDeHabEconomica(Hotel hotelLasFlores) {
        HabitacionEconomica habitacion = new HabitacionEconomica(); // creamos la habitacion
        habitacion.cargarHabitacion();
        // una vez que se crea la habitacion se lo pasas al hotel
        boolean agregado = hotelLasFlores.altaHabitacionEconomica(habitacion);
        if (agregado) { // si lo agrega confirma por mensaje
            Salida.mConfirmacion("Habitación agregada", "Confirmación");
        } else {
            Salida.mConfirmacion("No se ha creado una nueva habitación ya que se encontraba registrada..", "Confirmación");

        }
        return false;
    }
    private static boolean altaDeHabPremium(Hotel hotelLasFlores) {
        HabitacionPremium habitacion = new HabitacionPremium(); // creamos la habitacion
        habitacion.cargarHabitacion();
        // una vez que se crea la habitacion se lo pasas al hotel
        boolean agregado = hotelLasFlores.altaHabitacionPremium(habitacion);
        if (agregado) { // si lo agrega confirma por mensaje
            Salida.mConfirmacion("Habitación agregada", "Confirmación");
        } else {
            Salida.mConfirmacion("No se ha creado una nueva habitación ya que se encontraba registrada..", "Confirmación");

        }
        return false;
    }

    private static boolean altaDeRes(Hotel hotelLasFlores) {

        // ingresa el dni
        String dni = Ingreso.datoString("Ingrese el dni del cliente", "Ingreso", 1);
        Cliente cliente = hotelLasFlores.buscarClienteDni(dni);

        if (cliente == null) { // si no existe creamos cliente
            Salida.mAdvertencia("No se encontro el dni. Ingrese los datos", "Advertencia");
            cliente = new Cliente();
            cliente.cargarInfo();
            hotelLasFlores.agregarCliente(cliente); // le agregamos el cliente creado a (cliente en hotel)
        }
        // si llega hasta aca le pedimos el tipo de reserva
        boolean error = false;
        int tipoReserva = 0;
        do { tipoReserva = Ingreso.datoEntero("Que tipo de reserva quiere realizar? \n1.Reserva Individual \n2.Reserva Business", "Ingreso tipo reserva", 1);
        while (tipoReserva < 1 || tipoReserva > 2) {
            tipoReserva = Ingreso.datoEntero(
                    "Debe ingresar un número correcto.\n1.Reserva Individual \n2. Reserva Business", "Ingreso correcto",
                    1);
            if (tipoReserva < 1 || tipoReserva > 2) {
                error = true;
                Salida.mError("Debe ingresar un número correcto.", "Ingreso incorrecto");
            } else {
                error = false; // si es correcto sale del bucle
            }
        }} while (error);

        Reserva nuevaReserva; // creamos variable para agregar las reservas

        if (tipoReserva == 1) {// individual
            nuevaReserva = new ReservaIndividual();
            
        } else { // creo objeto para reserva business
            nuevaReserva = new ReservaBusiness();
            
        }

        nuevaReserva.cargarReserva(); // lo cargamos para que use la cantidad de personas y asisgne la habitacion
        nuevaReserva.setCliente(cliente);

        int cantPersonas= nuevaReserva.getCantPersonas();
    
        // tipo hab
        int tipoHabitacion;
        do {
            tipoHabitacion = Ingreso.datoEntero("Que tipo de habitación desea?\n 1. Económica \n2. Premium","Eleccion de hab" , 1);
        
        if (tipoHabitacion < 1 || tipoHabitacion > 2) {
            Salida.mError("Debe ingresar 1 para habitación económica o 2 para habitación premium", "error");
        }
    } while (tipoHabitacion < 1 || tipoHabitacion > 2);

Habitacion habitacionDisponible= null;

if (tipoHabitacion == 1) {
    habitacionDisponible = hotelLasFlores.buscarHabitacionDisponibleEconomica(cantPersonas);
} if (tipoHabitacion== 2) {
    habitacionDisponible = hotelLasFlores.buscarHabitacionDisponiblePremium(cantPersonas);
}

// existencias de hab
if (habitacionDisponible == null) {
    Salida.mError("No hay habitaciones disponibles para este tipo", "Sin disponibilidad");
    return false;
}

if(cantPersonas > habitacionDisponible.getLugares()) {
    Salida.mError("No hay lugar  para la cantidad de personas solicitadas", "Capacidad sin limite");
    return false;
}

habitacionDisponible.setDisponible(false);
        // cargamos los datos de la reserva
        nuevaReserva.setHabitacion(habitacionDisponible);
        nuevaReserva.setCantPersonas(cantPersonas);
        
        hotelLasFlores.agregarReserva(nuevaReserva); // agrego al método del hotel
        Salida.mMensaje("Reserva creada con éxito", "Exito");
        return false; // para que vuelva al menu principal

    }

    private static boolean altaResIndividual (Hotel hotelLasFlores) {
         ReservaIndividual reservaIndividual = new ReservaIndividual(); // creamos la rerserva
        reservaIndividual.cargarReserva();
        // una vez que se crea la reserva se lo pasas al hotel
        boolean agregado = hotelLasFlores.altaReservaIndividual(reservaIndividual);
        if (agregado) { 
            Salida.mConfirmacion("Reserva agregada", "Confirmación");
        } else {
            Salida.mConfirmacion("No se ha creado la reserva", "Confirmación");

        }
        return false;

    }

    private static boolean altaResBusinesses (Hotel hotelLasFlores){
        ReservaBusiness reservaBusiness= new ReservaBusiness();
        reservaBusiness.cargarReserva();
        boolean agregado= hotelLasFlores.altaReservaBusinesses (reservaBusiness);
        if (agregado) {
            Salida.mConfirmacion("Reserva agregada", "Confirmación");
        } else {
            Salida.mConfirmacion("No se ha podido crear la reserva", "Error");
        }
        return false;
    }

    private static boolean listaClientes(Hotel hotelLasFlores) {
        hotelLasFlores.mostrarClientes();
        return false;
    }

    private static boolean listaHabitaciones(Hotel hotelLasFlores) {
        hotelLasFlores.mostrarHabitaciones();
        return false;
    }

    private static boolean listaDeReservas(Hotel hotelLasFlores) {
        hotelLasFlores.mostrarReservas();
        return false;
    }

    private static boolean modificarDatosClientes(Hotel hotelLasFlores) {
        String dni= Ingreso.datoString("Ingrese el dni del cliente", "Ingreso dni", 1);
        hotelLasFlores.modificarDatosCliente(dni);
        return false;

    }

    private static boolean buscarClientesDni(Hotel hotelLasFlores) {
        String dni= Ingreso.datoString("Ingrese el dni del cliente", "Ingreso dni", 1);
        hotelLasFlores.buscarClienteDni(dni);
        return false;
    }

   
    
    private static boolean buscarReserva(Hotel hotelLasFlores) {
        int id = Ingreso.datoEntero("Ingrese el ID de la reserva que desea buscar:", "Buscar Reserva", 1);
        Reserva reservaEncontrada = hotelLasFlores.buscarReserva(id);
        if (reservaEncontrada != null) {
            Salida.mMensaje(reservaEncontrada.mostrarInfo(), "Reserva Encontrada");
        } else {
            Salida.mError("No se encontró ninguna reserva con ese ID.", "Reserva no encontrada");
        }
        return false;
    }
    
    private static boolean altaEmpleado(Hotel hotelLasFlores) {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.cargarInfo();
        // una vez que se crea el empleado se lo pasas al hotel
        hotelLasFlores.altaEmpleado(nuevoEmpleado);
        Salida.mConfirmacion("Empleado agregado", "Confirmación");
        return false; // para que vuelva al menu principal
    }
    private static boolean cancelarReserva(Hotel hotelLasFlores) {
        int id = Ingreso.datoEntero("Ingrese el ID de la reserva que desea cancelar:", "Cancelar Reserva", 1);
            hotelLasFlores.eliminarReserva(id);
        return false;
    }
    
    private static boolean mostrarEmpleados(Hotel hotelLasFlores) {
        hotelLasFlores.mostrarEmpleados();
        return false; // para que vuelva al menu principal
    }
    private static boolean buscarEmpleados(Hotel hotelLasFlores) {
        String dni = Ingreso.datoString("Ingrese el DNI del empleado que desea buscar:", "Buscar Empleado", 1);
        Empleado empleadoEncontrado = hotelLasFlores.buscarEmpleado(dni);
        if (empleadoEncontrado != null) {
            Salida.mMensaje(empleadoEncontrado.mostrarInfo(), "Empleado Encontrado");
        } else {
            Salida.mError("No se encontró ningún empleado con ese DNI.", "Empleado no encontrado");
        }
        return false; // para que vuelva al menu principal
    }
    private static boolean validarContrasena(Hotel hotel, String contrasena) {
        // Aquí puedes implementar la lógica para validar la contraseña del hotel
        // Por ejemplo, compararla con una contraseña almacenada en el sistema
        return hotel.getContrasena().equalsIgnoreCase(contrasena);
    }

     private static boolean ordenarClientes(Hotel hotelLasFlores) {
     hotelLasFlores.ordenarClientes();
     return false;
     }


}