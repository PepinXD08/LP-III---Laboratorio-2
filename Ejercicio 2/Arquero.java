package Proyecto;

public class Arquero extends PersonajeBase implements IAtaqueFisico {
    public Arquero(String nombre) { 
        super(nombre); 
    }
    
    @Override
    public void atacar() { 
        System.out.println(getNombre() + " dispara una flecha."); 
    }
    
    @Override
    public void usarHabilidad() { 
        System.out.println(getNombre() + " recarga munición."); 
    }
    
    @Override
    public void usarHabilidad(String objetivo) { 
        System.out.println(getNombre() + " lanza un cohete a " + objetivo); 
    }
    
    @Override
    public void golpeFisico() { 
        System.out.println("Golpe crítico."); 
    }
}