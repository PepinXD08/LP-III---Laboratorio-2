package Proyecto;

public class SistemaJuego {
    public static void main(String[] args) {
        PersonajeBase ahri = new Mago("Ahri");
        PersonajeBase jinx = new Arquero("Jinx");
        
        PersonajeBase[] team = {ahri, jinx};
        
        System.out.println(" Inicio de la peleita");
        for(PersonajeBase champ : team) {
            champ.atacar();
            champ.usarHabilidad("Teemo");
        }
        
        System.out.println("\nTotal de campeones en partida: " + PersonajeBase.contadorGlobal);
    }
}