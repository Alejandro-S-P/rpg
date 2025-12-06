package razas;

import enemigos.Enemigo;
import personajes.Personaje;

public class Humano extends Raza {
    //constructor
    public Humano(){//meter forma
        super("Humano", 10, 10, 10, 10);
    }
   


     @Override
    public void aplicaRaciales(Personaje personaje) {
        super.aplicaRaciales(personaje);
        //bonificaciones raciales adicionales si es necesario
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        personaje.setPs(personaje.getPs() + 10);
        System.out.println(personaje.getNombre() + " usa bendicion y aumenta sus PS a " + personaje.getPs());
    }
}



