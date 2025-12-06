package razas;

import enemigos.Enemigo;
import personajes.Personaje;

public class Elfo extends Raza {
    //constructor
    public Elfo(){//meter forma
        super("Elfo", 7, 7, 8, 6);
    }


    @Override
    public void aplicaRaciales(Personaje personaje) {
        super.aplicaRaciales(personaje);
        //bonificaciones raciales adicionales si es necesario
       
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " usa lanza onirica " + enemigo.getNombre() + " causando 25 de daño. ");
        enemigo.setPs(enemigo.getPs() - (personaje.getBaseDamage()));
    }
}
