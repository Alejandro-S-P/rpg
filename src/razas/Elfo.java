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
        personaje.setPs(personaje.getPs()+fuerza/2+destreza/2);
        personaje.setBaseDamage(personaje.getDañoFisico()+personaje.getBaseDamage());
        personaje.setArmor(personaje.getArmor()+fuerza/2);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion); 
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " usa lanza onirica " + enemigo.getNombre() + " causando 25 de daño. ");
        enemigo.setPs(enemigo.getPs() - (personaje.getBaseDamage()));
    }
}
