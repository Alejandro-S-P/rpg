package razas;

import enemigos.Enemigo;
import personajes.Personaje;

public class Enano extends Raza {
    //constructor
    public Enano(){//meter forma
        super("Enano", 20,5,2,8); 
    }




     @Override
    public void aplicaRaciales(Personaje personaje) {
        super.aplicaRaciales(personaje);
        //bonificaciones raciales adicionales si es necesario
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " usa defensa de la fragua " + personaje.getArmor()+ " aumenta la armadura de "+ personaje.getNombre());
       personaje.setArmor(personaje.getArmor() + 10);
    }
}
