package razas;

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
}


