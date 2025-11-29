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
        personaje.setPs(personaje.getPs()+fuerza/2+destreza/2);
        personaje.setBaseDamage(personaje.getDañoMagico()+personaje.getBaseDamage());
        personaje.setArmor(personaje.getArmor()+fuerza/2);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion); 
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " usa pistola de plasma contra " + enemigo.getNombre() + " causando 15 de daño. ");
        enemigo.setPs(enemigo.getPs() - (personaje.getBaseDamage()));
    }
}


