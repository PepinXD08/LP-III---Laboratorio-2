package banco;

public class CuentaCorriente extends Cuenta {
    private int retiros;
    private final int LIBRE_RETIROS = 3;
    private final double TARIFA_TRANSACCION = 3.0;


    public CuentaCorriente() {
        this.retiros = 0;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        retiros++;
        if (retiros > LIBRE_RETIROS) {
            super.retirar(TARIFA_TRANSACCION); 
        }
    }

    @Override
    public void consultar() {
        retiros = 0; 
    }
}