package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funeraria funeraria = Funeraria.getInstance();

        int opcion;
        do {
            System.out.println("------------------------------------");
            System.out.println("\n===== MENU FUNERARIA =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Mostrar clientes");
            System.out.println("5. Registrar empleado");
            System.out.println("6. Eliminar empleado");
            System.out.println("7. Actualizar empleado");
            System.out.println("8. Mostrar empleados");
            System.out.println("9. Adquirir servicio");
            System.out.println("10. Mostrar servicios adquiridos");
            System.out.println("11. Pagar deuda");
            System.out.println("12. Mostrar deuda");
            System.out.println("0. Salir");
            System.out.println("------------------------------------");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Identificación: ");
                    String id = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Año nacimiento: ");
                    int anio = sc.nextInt();
                    System.out.print("Mes nacimiento: ");
                    int mes = sc.nextInt();
                    System.out.print("Día nacimiento: ");
                    int dia = sc.nextInt();
                    sc.nextLine();

                    Cliente cliente = new Cliente.Builder()
                            .nombre(nombre)
                            .apellido(apellido)
                            .identificacion(id)
                            .email(email)
                            .fechaNacimiento(LocalDate.of(anio, mes, dia))
                            .deuda(0)
                            .build();

                    funeraria.registrarCliente(cliente);
                    break;

                case 3:
                    System.out.print("Identificación del cliente a actualizar: ");
                    String idActualizar = sc.nextLine();
                    if(!funeraria.clienteExiste(idActualizar)){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = sc.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoMail = sc.nextLine();
                    System.out.print("Año nacimiento: ");
                    int anioNuevo = sc.nextInt();
                    System.out.print("Mes nacimiento: ");
                    int mesNuevo = sc.nextInt();
                    System.out.print("Día nacimiento: ");
                    int diaNuevo = sc.nextInt();
                    sc.nextLine();
                    Cliente clienteExistente= funeraria.buscarCliente(idActualizar);
                    Cliente clienteAct = new Cliente.Builder()
                            .nombre(nuevoNombre)
                            .apellido(nuevoApellido)
                            .identificacion(idActualizar)
                            .email(nuevoMail)
                            .fechaNacimiento(LocalDate.of(anioNuevo, mesNuevo, diaNuevo))
                            .deuda(clienteExistente.getValorPendiente())
                            .build();

                    if (funeraria.actualizarCliente(idActualizar, clienteAct)) {
                        System.out.println("Cliente actualizado.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Identificación cliente: ");
                    String idEliminar = sc.nextLine();
                    if(!funeraria.clienteExiste(idEliminar)){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    funeraria.eliminarCliente(idEliminar);
                    break;
                case 4:
                    funeraria.mostrarClientes();
                    break;

                case 5:
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Apellido: ");
                    String a = sc.nextLine();
                    System.out.print("Identificación: ");
                    String idEmp = sc.nextLine();
                    System.out.print("Email: ");
                    String mail = sc.nextLine();
                    System.out.print("Año nacimiento: ");
                    int anioE = sc.nextInt();
                    System.out.print("Mes nacimiento: ");
                    int mesE = sc.nextInt();
                    System.out.print("Día nacimiento: ");
                    int diaE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cargo (VENDEDOR/AUXILIAR/CONDUCTOR): ");
                    String cargo = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    Empleado empleado1 = new Empleado.Builder()
                            .nombre(n)
                            .apellido(a)
                            .identificacion(idEmp)
                            .email(mail)
                            .fechaNacimiento(LocalDate.of(anioE, mesE, diaE))
                            .cargo(TipoCargo.valueOf(cargo.toUpperCase()))
                            .salario(salario)
                            .build();

                    funeraria.agregarEmpleado(empleado1);
                    break;
                case 7:
                    System.out.print("Identificación del empleado a actualizar: ");
                    String idEmpAct = sc.nextLine();
                    if(!funeraria.empleadoExiste(idEmpAct)){
                        System.out.println("Empleado no encontrado.");
                        break;
                    }
                    System.out.print("Nuevo nombre: ");
                    String nNom = sc.nextLine();
                    System.out.print("Nuevo apellido: ");
                    String nApe = sc.nextLine();
                    System.out.print("Nuevo email: ");
                    String nMail = sc.nextLine();
                    System.out.print("Año nacimiento: ");
                    int anioN = sc.nextInt();
                    System.out.print("Mes nacimiento: ");
                    int mesN = sc.nextInt();
                    System.out.print("Día nacimiento: ");
                    int diaN = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo cargo (VENDEDOR/AUXILIAR/CONDUCTOR): ");
                    String nCargo = sc.nextLine();
                    System.out.print("Nuevo salario: ");
                    double nSalario = sc.nextDouble();
                    sc.nextLine();

                    Empleado empAct = new Empleado.Builder()
                            .nombre(nNom)
                            .apellido(nApe)
                            .identificacion(idEmpAct)
                            .email(nMail)
                            .fechaNacimiento(LocalDate.of(anioN, mesN, diaN))
                            .cargo(TipoCargo.valueOf(nCargo.toUpperCase()))
                            .salario(nSalario)
                            .build();

                    if (funeraria.actualizarEmpleado(idEmpAct, empAct)) {
                        System.out.println("Empleado actualizado.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Identificación empleado: ");
                    String idEmpEliminar = sc.nextLine();
                    if(!funeraria.empleadoExiste(idEmpEliminar)){
                        System.out.println("Empleado no encontrado.");
                        break;
                    }
                    funeraria.eliminarEmpleado(idEmpEliminar);
                    break;
                case 8:
                    funeraria.mostrarEmpleados();
                    break;

                case 9:
                    System.out.print("Identificación cliente: ");
                    String idCliente = sc.nextLine();
                    if(!funeraria.clienteExiste(idCliente)){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    System.out.println("Elige servicio:");
                    System.out.println("1. Entierro");
                    System.out.println("2. Cremación");
                    System.out.println("3. Exhumación");
                    int opServ = sc.nextInt();
                    sc.nextLine();

                    try {
                        Servicio servicio = Servicio.ServicioFactory.crearServicio(opServ);
                        Cliente cliente1 = funeraria.buscarCliente(idCliente);

                        if (cliente1 != null) {
                            AdquirirServicio adq = new AdquirirServicio(cliente1, servicio);
                            funeraria.registrarServicio(adq);
                            System.out.println("Servicio adquirido con éxito.");
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Opción inválida de servicio.");
                    }
                    break;

                case 10:
                    funeraria.mostrarServiciosAdquiridos();
                    break;

                case 11:
                    System.out.print("Identificación cliente: ");
                    String idPag = sc.nextLine();
                    if(!funeraria.clienteExiste(idPag)){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    System.out.print("Monto a pagar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    funeraria.pagarServicio(idPag, monto);
                    break;
                case 12:
                    System.out.println("Identificación cliente:");
                    String identificacionC = sc.nextLine();
                    if(!funeraria.clienteExiste(identificacionC)){
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    Cliente cliente1=funeraria.buscarCliente(identificacionC);
                    if (cliente1 != null) {
                        cliente1.mostrarValorPendiente();
                    }else{
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        sc.close();
    }
}

