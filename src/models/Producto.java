package models;

public class Producto {

   private String codigo;
   private String nombre;
   private float  precio;
   private int cantidad;

    public Producto()
    {
    }

    public Producto(String codigo, String nombre, float precio, int cantidad)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;


    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String mostrarProducto()
    {
        return "Codigo: " + codigo + "\nNombre: " + nombre + "\nPrecio: " + precio + "\nCantidad: " + cantidad;
    }
    public float calcularMonto()
    {
        return precio * cantidad;
    }

    public boolean disponible()
    {
        return cantidad > 0;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                "Mostrar producto"+ mostrarProducto() +
                "Calcular Monto"+ calcularMonto() +
                "Disponible"+ disponible() +

                '}';
    }
}


