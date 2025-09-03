package co.edu.uniquindio.poo.app;


import java.util.Scanner;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Funeraria;
import co.edu.uniquindio.poo.model.TipoCargo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funeraria funeraria= Funeraria.getInstance();

        int opcion;

        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Soy Empleado");
            System.out.println("2. Soy Cliente");
            System.out.println("3. Soy Administrador");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if(iniciarSesion()){
                        // menu del empleado
                        mostrarMenuEmpleado(funeraria);
                    }
                    break;
                case 2:
                    if(iniciarSesion()){
                        // menu del empleado
                        mostrarMenuCliente(funeraria);
                    }
                    break;
                case 3:
                    if(iniciarSesion()){
                        // menu del empleado
                        mostrarMenuAdministrador(funeraria);
                    }
                    
                    System.out.println("Saliendo del administrador...");
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("⚠ Opción no válida, intenta de nuevo.");
            }
            System.out.println();

        } while (opcion != 3);

        sc.close();
    





    }

    private static void mostrarMenuAdministrador(Funeraria funeraria) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Actualizar Empleados");
            System.out.println("3. Eliminar Empleados");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    

                    System.out.println("Has elegido la opción: Registrar Empleado");
                    Scanner scannerEmpleado= new Scanner(System.in);
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombreEmpleado = scannerEmpleado.nextLine();
                    System.out.print("Ingrese el documento del cliente: ");
                    String documentoCliente = scannerEmpleado.nextLine();
                    System.out.print("Ingrese el email del cliente: ");
                    String email = scannerEmpleado.nextLine();

                     Empleado empleado= new Empleado.Builder()
                            .nombre(nombreEmpleado)
                            .identificacion(documentoCliente)
                            .email(email)
                            .build();

                    funeraria.registrarEmpleado(empleado);
                    System.out.println("Cliente registrado exitosamente.");
                    
                    break;
                   
                case 2:
                    // actualizar empleado por documento
                    System.out.println("Has elegido la opción: Actualizar Empleado");
                    System.out.println("Ingrese el documento del empleado a actualizar: ");
                    Scanner scannerActualizar = new Scanner(System.in);
                    String documentoActualizar = scannerActualizar.nextLine();
                    // nombre
                    System.out.print("Ingrese el nuevo nombre del empleado: ");
                    String nuevoNombre = scannerActualizar.nextLine();
                    
                    System.out.print("Ingrese el nuevo email del empleado: ");
                    String nuevoEmail = scannerActualizar.nextLine();

                    // tipo cargo
                    System.out.print("Ingrese el nuevo cargo del empleado (1. ADMINISTRADOR, 2. ATENCION_AL_CLIENTE, 3. ASISTENTE): ");
                    String nuevoCargoStr = scannerActualizar.nextLine();
                    TipoCargo nuevoCargo = null;

                    if(nuevoCargoStr.equals("1") || nuevoCargoStr.equals("2") || nuevoCargoStr.equals("3")){
                        // convertir a enum
                       
                        switch (nuevoCargoStr) {
                            case "1":
                                nuevoCargo = TipoCargo.AUXILIAR;
                                break;
                            case "2":
                                nuevoCargo =TipoCargo.CONDUCTOR;
                                break;
                            case "3":
                                nuevoCargo =TipoCargo.VENDEDOR;
                                break;
                        }

                    }
                    
                    funeraria.actualizarEmpleado(documentoActualizar, nuevoNombre, nuevoEmail, nuevoCargo);
                    
                    // actualizar empleado
                    //funeraria.actualizarEmpleado(documentoActualizar, nuevoNombre, nuevoEmail);


                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
            System.out.println();

        } while (opcion != 4);
    }

    private static void mostrarMenuCliente(Funeraria funeraria) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ CLIENTE =====");
            System.out.println("1. Ver Servicios Disponibles");
            System.out.println("2. Ver Productos Disponibles");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido la opción: Ver Servicios Disponibles");
                    // Aquí podrías llamar a métodos para mostrar servicios
                    break;
                case 2:
                    System.out.println("Has elegido la opción: Ver Productos Disponibles");
                    // Aquí podrías llamar a métodos para mostrar productos
                    break;
                case 3:
                    
                    System.out.println("Volviendo al Menú Principal...");

                    break;
                default:
                    System.out.println("⚠ Opción no válida, intenta de nuevo.");
            }
            System.out.println();

        } while (opcion != 3);
    }

    private static void mostrarMenuEmpleado(Funeraria funeraria) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ EMPLEADO =====");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Eliminar Cliente");
            System.out.println("3. Actualizar Cliente");            
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido la opción: Registrar Cliente");
                    Scanner scannerCliente = new Scanner(System.in);
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scannerCliente.nextLine();
                    System.out.print("Ingrese el documento del cliente: ");
                    String documentoCliente = scannerCliente.nextLine();
                    System.out.print("Ingrese el email del cliente: ");
                    String email = scannerCliente.nextLine();

                    Cliente cliente = new Cliente.Builder()
                            .nombre(nombreCliente)
                            .identificacion(documentoCliente)
                            .email(email)
                            .fechaNacimiento(null)
                            .deuda(0)
                            .build();

                    funeraria.registrarCliente(cliente);
                    System.out.println("Cliente registrado exitosamente.");
                    
                    break;
                case 2:
                    // Eliminar cliente
                    System.out.println("Ingresa el documento del cliente a eliminar: ");
                    Scanner scannerEliminar = new Scanner(System.in);
                    String documentoEliminar = scannerEliminar.nextLine();
                    funeraria.eliminarCliente(documentoEliminar);
                    break;

                
                case 3:
                    // Actualizar cliente por documento
                    System.out.println("Ingrese el documento del cliente a actualizar: ");
                    Scanner scannerActualizar = new Scanner(System.in);
                    String documentoActualizar = scannerActualizar.nextLine();
                    // nombre
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    String nuevoNombre = scannerActualizar.nextLine();
                    // email
                    System.out.print("Ingrese el nuevo email del cliente: ");
                    String nuevoEmail = scannerActualizar.nextLine();

                    funeraria.actualizarCliente(documentoActualizar, nuevoNombre, nuevoEmail);

                    break;
                case 4:
                    System.out.println("Volviendo al Menú Principal...");
                default:
                    System.out.println("⚠ Opción no válida, intenta de nuevo.");
            }
            System.out.println();

        } while (opcion != 4);
        }

    private static Boolean iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String username = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        // Aquí podrías agregar la lógica para verificar las credenciales
        System.out.println("Iniciando sesión para el usuario: " + username);
        return true;
    }    
}
    
