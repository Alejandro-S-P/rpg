package razas;

import personajes.Personaje;

public class Orco extends Raza {
    //constructor
    public Orco(){//meter forma
        super("Orco", 25, 4, 5, 8);
    }
   



     @Override
    public void aplicaRaciales(Personaje personaje) {
        super.aplicaRaciales(personaje);
        //bonificaciones raciales adicionales si es necesario
        personaje.setPs(personaje.getPs()+fuerza+destreza/2);
        personaje.setBaseDamage(personaje.getDañoFisico()+personaje.getBaseDamage());
        personaje.setArmor(personaje.getArmor()+fuerza/2);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion); 
    }
}
