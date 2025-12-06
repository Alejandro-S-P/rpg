package razas;

import enemigos.Enemigo;
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
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " grito de guerra " + personaje.getNombre() + " recibe aumento de daño y armadura");
        personaje.setBaseDamage(personaje.getBaseDamage()+20);
        personaje.setArmor(personaje.getArmor()+20);
    }
}
