import java.util.Scanner;

public class Main {

     static double saldo = 1000.00;
     static final String clave = "materia123";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al Cajero Automático!");

        boolean autenticado = false;
        int intentos = 3;


        while (!autenticado && intentos > 0) {
            System.out.print("Ingrese su clave: ");
            String entradaClave = scanner.nextLine();
            if (entradaClave.equals(clave)) {
                autenticado = true;
            } else {
                intentos--;
                System.out.println("Clave incorrecta. Intentos restantes: " + intentos);
            }
        }

        if (autenticado) {
            mostrarMenu(scanner);
        } else {
            System.out.println("Ha excedido el número máximo de intentos. Tarjeta bloqueada.");
        }

        scanner.close();
    }

    private static void mostrarMenu(Scanner scanner) {
        int opciones;
        do {
            System.out.println("//Menú Principal//");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar un depósito");
            System.out.println("3. Realizar un retiro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opciones = scanner.nextInt();
            scanner.nextLine();

            switch (opciones) {
                case 1:
                    double saldoCantidad = scanner.nextDouble();
                    consultarSaldo(saldoCantidad);
                    break;
                case 2:
                    System.out.print("Ingresar una cantidad para el deposito: $");
                    double cantidadDeposito = scanner.nextDouble();
                    depositar(cantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double cantidadRetiro = scanner.nextDouble();
                    retirar(cantidadRetiro);
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción válida!");
                    break;
            }
        } while (opciones != 4);
    }

    private static void consultarSaldo(double cantidad) {

        System.out.println("Saldo actual: $" + saldo);

    }
    private static void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error: La cantidad ingresada es inválida.");
        }
    }

    private static void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error: Fondos insuficientes o cantidad inválida.");
        }


    }

}

