package enemigos;

import personajes.Personaje;

public class NoMuertoMago extends Enemigo {
    //constructor
    public NoMuertoMago(String nombre, int ps, int daño, String arma, int agilidad){
        super(nombre, ps, daño, arma, agilidad);
    }
@Override
public void enemigoAtacar(Personaje personaje, Enemigo enemigo) {
    int dañoTotal = daño + (agilidad / 2);
    String mensaje = "";

    int opcion = (int)(Math.random() * 3) + 1;

    switch (opcion) {
        case 1: mensaje = "lanza rayo oscuro"; break;
        case 2: dañoTotal += 5; mensaje = "invoca bola de fuego maldita"; break;
        case 3: dañoTotal += 10; mensaje = "desata tormenta de sombras"; break;
    }

    System.out.println(nombre + " " + mensaje + " contra " + personaje.getNombre() +
                       " causando " + dañoTotal + " de daño.");
    personaje.setPs(personaje.getPs() - dañoTotal);

    if (ps > 0 && ps <= 25) {
        int dañoUltimoAliento = (daño * 2) + agilidad;
        System.out.println(nombre + " usa Último Aliento infligiendo " + dañoUltimoAliento + " de daño adicional.");
        personaje.setPs(personaje.getPs() - dañoUltimoAliento);
    }
}
}
