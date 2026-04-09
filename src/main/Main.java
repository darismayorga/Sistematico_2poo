import java.util.Scanner;
import models.Producto;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float valorTotalInventario = 0.0f;

        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Ciclo for para registrar los productos uno por uno
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("\n--- Ingresando Producto " + (i + 1) + " ---");

            System.out.print("Código: ");
            String codigo = scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio: ");
            float precio = scanner.nextFloat();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer nuevamente

            // Asumo que creaste un constructor en tu clase Producto que recibe estos 4 parámetros
            Producto producto = new Producto(codigo, nombre, precio, cantidad);

            System.out.println("\n--- Información del Producto Ingresado ---");

            // 1. Mostrar su información
            System.out.println(producto.mostrarProducto());

            // 2. El valor total (precio x cantidad)
            float valorProducto = producto.calcularMonto();
            System.out.println("Valor total (precio x cantidad): $" + valorProducto);

            // 3. Si está disponible (cantidad > 0)
            if (producto.disponible()) {
                System.out.println("Disponibilidad: Está disponible en inventario.");
            } else {
                System.out.println("Disponibilidad: Agotado.");
            }

            // Acumular el valor para el final
            valorTotalInventario += valorProducto;
        }

        // Al finalizar, mostrar el valor total del inventario acumulado
        System.out.println("\n==========================================");
        System.out.println("Valor total del inventario (acumulado): $" + valorTotalInventario);
        System.out.println("==========================================");

        scanner.close();
    }
}