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
    }
    @Override
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        System.out.println(personaje.getNombre() + " aullido " + personaje.getBaseDamage()+" aumento de daño de "+ personaje.getNombre());
        personaje.setBaseDamage(personaje.getBaseDamage()+10);
    }
}
