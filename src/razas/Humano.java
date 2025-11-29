package razas;

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
        personaje.setPs(personaje.getPs()+fuerza/2+destreza/2);
        personaje.setBaseDamage(((personaje.getDañoMagico()/2)+(personaje.getDañoFisico()/2))+personaje.getBaseDamage());
        personaje.setArmor(personaje.getArmor()+fuerza/2);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion); 
    }
}



