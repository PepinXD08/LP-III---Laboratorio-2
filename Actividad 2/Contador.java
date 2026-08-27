package trabajo;
public class Contador {
    static int acumulador = 0;
    final static int VALOR_INICIAL = 10;
    
    // j.1. Variable de clase (static) para contar cuántos objetos se crean
    static int nContadores = 0; 
    
    // j.2. Variable de clase (static) para guardar el valor del último creado
    static int ultimoContador = 0; 
    
    private int valor;

    public static int acumulador() {
        return acumulador;
    }

    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        
        // Cada vez que entra a este constructor (ya sea directo o por delegación):
        nContadores++;           // Aumentamos el número de contadores
        ultimoContador = valor;  // Guardamos el valor inicial de este último
    }

    public Contador() {
        this(Contador.VALOR_INICIAL);
    }

    public void inc() {
        this.valor++;
        acumulador++;
    }

    public int getValor(){
        return this.valor;
    }
}
