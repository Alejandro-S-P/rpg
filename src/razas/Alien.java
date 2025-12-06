package razas;

import enemigos.Enemigo;
import personajes.Personaje;

public class Alien extends Raza {
    //constructor
    public Alien(){//meter forma
        super("Alien", 6, 12, 5, 10);
    }



     @Override
    public void aplicaRaciales(Personaje personaje) {
        super.aplicaRaciales(personaje);
        //bonificaciones raciales adicionales si es necesario
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " usa pistola de plasma contra " + enemigo.getNombre() + " causando 15 de daño. ");
        enemigo.setPs(enemigo.getPs() - (personaje.getBaseDamage()));
    }
}


