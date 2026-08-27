package banco;

public class Cuenta {
    private double saldo;

    public void depositar(double monto) {
        saldo = saldo + monto;
    }

    public void retirar(double monto) {
        saldo = saldo - monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consultar() {
    }
}