package Proyecto;

public class Mago extends PersonajeBase implements IAtaqueMagico {
    public Mago(String nombre) { 
        super(nombre); 
    }
    
    @Override
    public void atacar() { 
        System.out.println(getNombre() + " ataca con su báculo."); 
    }
    
    @Override
    public void usarHabilidad() { 
        System.out.println(getNombre() + " castea magia al aire."); 
    }
    
    @Override
    public void usarHabilidad(String objetivo) { 
        System.out.println(getNombre() + " lanza su definitiva a " + objetivo); 
    }
    
    @Override
    public void lanzarHechizo() { 
        System.out.println("¡Orbe de engaño!"); 
    }
}