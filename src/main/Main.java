package main;
import java.util.Scanner;
import models.Cliente;
import models.Cuenta;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args)
    {

        //Registro de Cliente
        JOptionPane.showMessageDialog(null, "🏦 Bienvenido al Sistema Bancario\nPor Favor ingrese sus datos.");

        String id = JOptionPane.showInputDialog("Ingrese su ID / Cédula:");
        String nombres = JOptionPane.showInputDialog("Ingrese sus Nombres:");
        String apellidos = JOptionPane.showInputDialog("Ingrese sus Apellidos:");

        Cliente nuevoCliente = new Cliente(id, nombres, apellidos);

        String numero = JOptionPane.showInputDialog("Ingrese el número asignado para su nueva cuenta:");

        Cuenta miCuenta = new Cuenta(numero, nuevoCliente);

        JOptionPane.showMessageDialog(null, "🎉 ¡Cuenta creada con éxito!\n\n" + miCuenta.mostrarDatos(), "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        //Menu
        int opcion = 0;
        String menu = "====== MENÚ BANCARIO ======\n"
                + "1. Consultar saldo\n"
                + "2. Depositar dinero\n"
                + "3. Retirar dinero\n"
                + "4. Salir\n\n"
                + "Elige una opción:";

        do {
            try {
                String input = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);

                // Si el usuario presiona "Cancelar" o la "X" en la ventana
                if (input == null) {
                    opcion = 4;
                    break;
                }

                opcion = Integer.parseInt(input); // Convertimos el texto a número

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "💰 Tu saldo actual es: $" + miCuenta.consultarSaldo(), "Consulta de Saldo", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        String depInput = JOptionPane.showInputDialog(null, "¿Cuánto deseas depositar? $", "Depósito", JOptionPane.QUESTION_MESSAGE);
                        if (depInput != null) {
                            double deposito = Double.parseDouble(depInput);
                            miCuenta.depositar(deposito); // La lógica y validación siguen en la clase Cuenta
                            JOptionPane.showMessageDialog(null, "Transacción procesada.\nTu saldo actual ahora es: $" + miCuenta.consultarSaldo());
                        }
                        break;
                    case 3:
                        String retInput = JOptionPane.showInputDialog(null, "¿Cuánto deseas retirar? $", "Retiro", JOptionPane.QUESTION_MESSAGE);
                        if (retInput != null) {
                            double retiro = Double.parseDouble(retInput);
                            miCuenta.retirar(retiro); // La lógica y validación (no negativos) se aplica aquí
                            JOptionPane.showMessageDialog(null, "Transacción procesada.\nTu saldo actual ahora es: $" + miCuenta.consultarSaldo());
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "👋 Saliendo del sistema. ¡Gracias por preferirnos!", "Despedida", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "⚠️ Opción no válida. Ingresa un número del 1 al 4.", "Opción Incorrecta", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Esto atrapa el error si el usuario escribe "hola" en vez de un número
                JOptionPane.showMessageDialog(null, "⚠️ Error: Por favor, ingresa únicamente valores numéricos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 4);
    }
}

