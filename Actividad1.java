package vizcarra;

public class Main {
	public static class Coche {
		String marca;
		String modelo;
		int anio;
		double precio;
		
		public boolean aplicarDescuento(double descuento) {
            if (anio < 2010) {
                precio = precio - descuento;
                return true;
            } else {
                return false;
            }
        }
		public Coche() {
			this.marca = "Desconocido";
			this.modelo = "Generico";
			this.anio = 2026;
			this.precio = 37000.00;
		}
		public Coche(String marca, String modelo, int anio, double precio) {
			this.marca = marca;
			this.modelo = modelo;
			this.anio = anio;
			this.precio = precio;
		}
	}
	
	public static class EjemploCoche {
		public static void main(String[] args) {
			Coche coche1 = new Coche();
			Coche coche2 = new Coche("KIA","Picanto",2009,27840.89);
			System.out.println(coche1.aplicarDescuento(7000.00));
			System.out.println(coche2.aplicarDescuento(5360.54));
		}
	}
}
