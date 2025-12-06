package enemigos;

import personajes.Personaje;
import game.Estado;

public class DragonOscuro extends Enemigo {
    public DragonOscuro(String nombre, int ps, int daño, String arma, int agilidad) {
        super(nombre, ps, daño, arma, agilidad);
    }

    @Override
    public void enemigoAtacar(Personaje personaje, Enemigo enemigo) {
        int dañoTotal = daño + (agilidad / 2);
        String mensaje = "";

        int opcion = (int)(Math.random() * 3) + 1;

        switch (opcion) {
            case 1: 
                mensaje = "usa garra sombria";
                personaje.aplicarEstado(Estado.SANGRADO);
                break;
            case 2:
                dañoTotal += 10; 
                mensaje = "lanza aliento de las sombras";
                break;
            case 3: 
                dañoTotal += 15; 
                mensaje = "invoca eclipse total";
                break;
        }

        System.out.println("🌑 " + nombre + " " + mensaje + " contra " + personaje.getNombre() + " causando " + dañoTotal + " de daño.");
        personaje.recibirDaño(dañoTotal);

        if (ps > 0 && ps <= 50) {
            int dañoFuria = (daño * 3) + agilidad;
            System.out.println("🌑🌑 " + nombre + " usa VACIO ETERNO infligiendo " + dañoFuria + " de daño!");
            personaje.recibirDaño(dañoFuria);
        }
    }
}
