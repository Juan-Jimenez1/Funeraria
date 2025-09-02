package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funeraria funeraria= Funeraria.getInstance();



        //FALTA TERMINAR EL MAIN COMPLETO, REESTRUCTURARLO
        //REVISA TODAS LAS CLASES Y ORGANIZALAS UN POCO PORFA
        int opcion;
        do {
            System.out.println("\n===== MENÚ FUNERARIA =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Mostrar clientes");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Adquirir servicio");
            System.out.println("6. Mostrar servicios adquiridos de un cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Identificación: ");
                    String id = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int anio = sc.nextInt();
                    System.out.print("Mes: ");
                    int mes = sc.nextInt();
                    System.out.print("Día: ");
                    int dia = sc.nextInt();
                    sc.nextLine();

                    // Usando Builder para cliente
                    Cliente cliente = new Cliente.Builder()
                            .nombre(nombre)
                            .apellido(apellido)
                            .identificacion(id)
                            .email(email)
                            .fechaNacimiento(LocalDate.of(anio, mes, dia))
                            .build();

                    funeraria.registrarCliente(cliente);
                    System.out.println(cliente);
                    System.out.println("Cliente registrado con éxito");
                }
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Identificación: ");
                    String id = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("");
                    String cargo = sc.nextLine();

                    // Usando Builder para empleado
                    Empleado empleado = new Empleado.Builder()
                            .nombre(nombre)
                            .apellido(apellido)
                            .identificacion(id)
                            .email(email)
                            .fechaNacimiento(LocalDate.now()) // de ejemplo
                            .cargo(TipoCargo.valueOf(cargo.toUpperCase()))
                            .build();

                    funeraria.registrarEmpleado(empleado);
                    System.out.println(empleado);

                }
                case 3 -> funeraria.mostrarClientes();
                case 4 -> funeraria.mostrarEmpleados();
                case 5 -> {
                }
                case 6 -> {

                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
    
