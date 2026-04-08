import java.util.Scanner;
import models.Producto;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de productos: ");
        int n = sc.nextInt();
        sc.nextLine();

        float totalInventario = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nProducto #" + (i + 1));

            System.out.print("Codigo: ");
            String codigo = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Precio: ");
            float precio = sc.nextFloat();

            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            Producto p = new Producto(codigo, nombre, precio, cantidad);

            System.out.println("\n--- Producto ---");
            System.out.println(p.mostrarProducto());

            System.out.println("Monto total: " + p.calcularMonto());

            System.out.println("Disponible: " + p.disponible());

            totalInventario += p.calcularMonto();
        }

        System.out.println("\nTotal de inventario: " + totalInventario);
    }
}