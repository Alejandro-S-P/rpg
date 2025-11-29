package razas;

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
        personaje.setPs(personaje.getPs()+fuerza/2+destreza/2);
        personaje.setBaseDamage(personaje.getDañoFisico()+personaje.getBaseDamage());
        personaje.setArmor(personaje.getArmor()+fuerza/2);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion); 
    }
}
