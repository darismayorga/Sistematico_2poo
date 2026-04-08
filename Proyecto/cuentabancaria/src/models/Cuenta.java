package models;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        } else {
            // En vez de imprimir, LANZAMOS un error
            throw new IllegalArgumentException("No se pueden depositar cantidades negativas o cero.");
        }
    }

    public double retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a 0.");
        } else if (monto > this.saldo) {
            // Lanzamos el error si no le alcanza la plata
            throw new IllegalArgumentException("Fondos insuficientes. Su saldo actual es $" + this.saldo);
        } else {
            this.saldo -= monto;
            return monto;
        }
    }

    public String mostrarDatos() {
        return "Cuenta N°: " + this.numeroCuenta +
                " | Titular: " + this.cliente.getNombre() + " " + this.cliente.getApellidos() +
                " | Saldo: $" + this.saldo;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}