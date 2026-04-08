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
            System.out.println("✅ Depósito exitoso.");
        } else {
            System.out.println("❌ Error: No se pueden depositar cantidades negativas o cero.");
        }
    }

    public double retirar(double monto) {
        if (monto <= 0) {
            System.out.println("❌ Error: El monto a retirar debe ser mayor a 0.");
            return 0;
        } else if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("✅ Retiro exitoso.");
            return monto;
        } else {
            System.out.println("❌ Error: Fondos insuficientes. Saldo actual: $" + this.saldo);
            return 0;
        }
    }

    public String mostrarDatos() {
        return "Cuenta N°: " + this.numeroCuenta +
                " | Titular: " + this.cliente.getNombre() + " " + this.cliente.getApellidos() +
                " | Saldo: $" + this.saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}


