package vizcarra;

public class Main3 {
	public static class Persona {
	    private int id;
	    private String nombre;
	    private String apellido;
	    private Cuenta cuenta;

	    public Persona(int id, String nombre, String apellido) {
	        this.id = id;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.cuenta = new Cuenta(id);
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public Cuenta getCuenta() {
	        return cuenta;
	    }

	    @Override
	    public String toString() {
	        return "Persona: " + "ID = " + id + ", Nombre = '" + nombre + '\'' + ", Apellido = '" + apellido + '\'' + ", Cuenta = " + cuenta;
	    }
	}
	
	public static class Cuenta {
	    private int numero;
	    private double saldo;

	    public Cuenta(int numero, double saldo) {
	        this.numero = numero;
	        this.saldo = saldo;
	    }

	    public Cuenta(int numero) {
	        this(numero, 0);
	    }

	    public int getNumCuenta() {
	        return numero;
	    }

	    public void setNumCuenta(int numero) {
	        this.numero = numero;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

	    @Override
	    public String toString() {
	        return "Cuenta: " + "Número = " + numero + ", Saldo = " + saldo;
	    }
	}
	
	public static void main(String[] args) {
		Persona persona = new Persona(1,"Alfredo","Diaz");
        persona.getCuenta().setSaldo(1500.50);
        System.out.println(persona);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
        System.out.println("Número de cuenta: " + persona.getCuenta().getNumCuenta());
        System.out.println("Saldo: " + persona.getCuenta().getSaldo());
	}

}
