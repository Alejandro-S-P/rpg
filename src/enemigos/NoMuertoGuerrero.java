package enemigos;

import personajes.Personaje;

public class NoMuertoGuerrero extends Enemigo {
    //constructor
    public NoMuertoGuerrero(String nombre, int ps, int daño, String arma, int agilidad){
        super(nombre, ps, daño, arma, agilidad);
    }
@Override
public void enemigoAtacar(Personaje personaje, Enemigo enemigo) {
    // Último Aliento primero (exclusivo)
    if (ps > 0 && ps <= 25) {
        int dañoUltimoAliento = (daño * 2) + agilidad;
        System.out.println(nombre + " usa Último Aliento infligiendo " + dañoUltimoAliento + " de daño!");
        personaje.recibirDaño(dañoUltimoAliento);
        return;
    }

    int dañoTotal = daño + (agilidad / 2);
    String mensaje = "";

    int opcion = (int)(Math.random() * 3) + 1;

    switch (opcion) {
        case 1: mensaje = "golpea con escudo maldito"; break;
        case 2: dañoTotal += 5; mensaje = "realiza corte espectral"; break;
        case 3: dañoTotal += 10; mensaje = "ejecuta remate infernal"; break;
    }

    System.out.println(nombre + " " + mensaje + " contra " + personaje.getNombre() +
                       " causando " + dañoTotal + " de daño.");
    personaje.recibirDaño(dañoTotal);
}


}
