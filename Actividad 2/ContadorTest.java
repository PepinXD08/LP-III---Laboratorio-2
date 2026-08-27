package trabajo;
public class ContadorTest {
    public static void main(String[] args) {
        Contador c1 = new Contador(3);
        Contador c2 = new Contador(10);
        Contador c3 = new Contador(); 
        
        c1.inc();
        c1.inc();
        c2.inc();
        
        System.out.println("Acumulador global: " + Contador.acumulador());
        
        System.out.println("Resultados ");
        System.out.println("Número de contadores creados: " + Contador.nContadores);
        System.out.println("Valor inicial del último contador: " + Contador.ultimoContador);
    }
}
