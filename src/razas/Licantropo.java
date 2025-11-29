package razas;

import enemigos.Enemigo;
import personajes.Personaje;

public class Licantropo extends Raza {
    //constructor
    public Licantropo(){//meter forma
        super("Licantropo", 20, 5, 10, 10);
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
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " aullido " + personaje.getBaseDamage()+"aumento de daño de "+ personaje.getNombre());
        personaje.setBaseDamage(personaje.getBaseDamage()+10);
    }
}
