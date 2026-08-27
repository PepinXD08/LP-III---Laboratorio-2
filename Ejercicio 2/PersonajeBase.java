package Proyecto;
public abstract class PersonajeBase {
    public static int contadorGlobal = 0;
    public final int SALUD_MAXIMA = 1000; 
    
    private String nombre;
    protected int nivel;
    public int salud;
    Inventario inventario;
    
    Habilidad[] habilidades;
    
    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.salud = SALUD_MAXIMA;
        this.nivel = 1;
        this.habilidades = new Habilidad[]{new Habilidad("Ataque Básico")}; 
        contadorGlobal++;
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    private void regenerar() { 
        salud += 10; 
    } 
    
    protected void subirNivel() { 
        nivel++; 
    } 
    
    void recibirDano(int dano) { 
        salud -= dano; 
    } 
    
    public abstract void atacar();
    public abstract void usarHabilidad(); 
    public abstract void usarHabilidad(String objetivo);
}