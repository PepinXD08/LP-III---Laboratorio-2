package banco;

import java.util.Scanner;

public class AppBanco {
    public static void main(String[] args) {

        Cuenta[] cuentas = new Cuenta[10];
        
        for (int i = 0; i < 5; i++) {
            cuentas[i] = new CuentaCorriente(); 
            cuentas[i + 5] = new CuentaAhorro(5.0); 
        }

        Scanner in = new Scanner(System.in);
        boolean done = false;

        System.out.println("Sistema de Gestión Bancaria ");
        System.out.println("Cuentas disponibles: 0-9");

        while (!done) {
            System.out.print("\nA)Depositar B)Retirar C)Consultar D)Salir: ");
            String op = in.next().toUpperCase(); 

            // ¡Aquí estaba el error! Cambiado para evaluar "A" (Depositar) o "B" (Retirar)
            if (op.equals("A") || op.equals("B")) {
                System.out.print("Ingrese un numero de cuenta (0-9) y un monto: ");
                int num = in.nextInt();
                double monto = in.nextDouble();


                if(num >= 0 && num < cuentas.length) {
                    if (op.equals("A")) {
                        cuentas[num].depositar(monto);
                        System.out.println("Depósito exitoso.");
                    } else {
                        cuentas[num].retirar(monto);
                        System.out.println("Retiro exitoso.");
                    }
                    System.out.println("Saldo actual: S/." + cuentas[num].getSaldo());
                } else {
                    System.out.println("Error: Número de cuenta inválido.");
                }

            } else if (op.equals("C")) {
                System.out.println("\n--- Consultando y aplicando políticas mensuales ---");
                for (int n = 0; n < cuentas.length; n++) {

                    cuentas[n].consultar();
                    
                    String tipo = cuentas[n].getClass().getSimpleName();
                    System.out.println("Cuenta " + n + " (" + tipo + ") - Saldo: S/." + cuentas[n].getSaldo());
                }
            } else if (op.equals("D")) {
                System.out.println("Saliendo del sistema...");
                done = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        in.close();
    }
}