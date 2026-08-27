package vizcarra;

public class Main3 {
	public static class Automovil {
		private String placa;
		private int puertas;
		private String marca;
		private String modelo;
		private Motor motor;
		
		public Automovil(String placa, int puertas, String marca, String modelo){
			this.placa = placa;
			this.puertas = puertas;
			this.marca = marca;
			this.modelo = modelo;
		}
		
		public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public int getPuertas() {
            return puertas;
        }

        public void setPuertas(int puertas) {
            this.puertas = puertas;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }
        
        public String getModelo() {
        	return modelo;
        }
        
        public void setModelo(String modelo) {
        	this.modelo = modelo;
        }
        
        public Motor getMotor() {
        	return motor;
        }
        
        public void setMotor(Motor motor) {
            this.motor = motor;
        }
		
        @Override
		public String toString() {
	        return "Auto [Placa = " + placa + ", Num. puertas = " + puertas + ", Marca = " + marca + ", Modelo = " + modelo + "]";
	    }
	}
	
	public static class Motor {
		private int numMotor;
		private int revPorMin;
		
		public Motor(int numMotor, int revPorMin) {
			this.numMotor = numMotor;
			this.revPorMin = revPorMin;
		}
		
		public int getNumMotor() {
			return numMotor;
		}
		
		public void setNumMotor(int numMotor) {
			this.numMotor = numMotor;
		}
		
		public int getRevPorMin() {
			return revPorMin;
		}
		
		public void setRevPorMin(int revPorMin) {
			this.revPorMin = revPorMin;
		}
		
		@Override
		public String toString() {
			return "Motor [Num. Motor = " + numMotor + ", Rev. Por Minuto = " + revPorMin + "]";
		}
	}
	
	public static class TestAgregacion {
		public static void main(String[] args) {
	        Motor motor1 = new Motor(23561, 5390);
	        Motor motor2 = new Motor(67890, 6576);
	        
	        Automovil auto1 = new Automovil("V8C-123",4,"Toyota","Corolla");
	        Automovil auto2 = new Automovil("ABC-456",2,"Fiat","Topolino");
	        
	        auto1.setMotor(motor1);
	        auto2.setMotor(motor2);
	        
	        System.out.println("Auto 1");
	        System.out.println(auto1);
	        System.out.println(motor1);

	        System.out.println("Auto 2");
	        System.out.println(auto2);
	        System.out.println(motor2);
		}
	}
}
