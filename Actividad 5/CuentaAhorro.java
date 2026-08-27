package banco;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double minSaldo;


    public CuentaAhorro(double tasaInteres) {
        this.tasaInteres = tasaInteres;
        this.minSaldo = 0;
    }

    public void setTasaInteres(double interes) {
        this.tasaInteres = interes;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto); 
        double saldoActual = getSaldo();
        if (saldoActual < minSaldo || minSaldo == 0) {
            minSaldo = saldoActual;
        }
    }

    @Override
    public void consultar() {
        double interes = minSaldo * tasaInteres / 100;
        depositar(interes);
        minSaldo = getSaldo(); 
    }
}
