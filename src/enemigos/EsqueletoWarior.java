package enemigos;

import personajes.Personaje;

public class EsqueletoWarior extends Enemigo {
    //constructor
    public EsqueletoWarior(String nombre, int ps, int daño, String arma, int agilidad){
        super(nombre, ps, daño, arma, agilidad);
    }
@Override
public void enemigoAtacar(Personaje personaje, Enemigo enemigo) {
    int dañoTotal = daño + (agilidad / 2);
    String mensaje = "";

    int opcion = (int)(Math.random() * 3) + 1;

    switch (opcion) {
        case 1: mensaje = "golpea con espada rota"; break;
        case 2: dañoTotal += 5; mensaje = "realiza embestida descarnada"; break;
        case 3: dañoTotal += 10; mensaje = "ejecuta hachazo brutal"; break;
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
