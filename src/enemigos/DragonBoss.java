package enemigos;

import personajes.Personaje;

public class DragonBoss extends Enemigo {
 //constructor
    public DragonBoss(String nombre, int ps, int daño, String arma,int agilidad){
        // Valores por defecto para DragonBoss: agilidad
        super(nombre, ps, daño, arma, agilidad);
    }
    //metodos
    @Override
    public void enemigoAtacar(Personaje personaje, Enemigo enemigo) {
        // Calcular daño con agilidad
        int dañoTotal = daño + (agilidad / 2);
        String mensaje = "";

        int opcion = (int)(Math.random() * 3) + 1; // ataque aleatorio

        switch (opcion) {
            case 1: 
                mensaje = "dispara flecha rota";
                break;
            case 2:
                dañoTotal += 5; 
                mensaje = "lanza flecha venenosa";
                break;
            case 3: 
                dañoTotal += 10; 
                mensaje = "dispara flecha explosiva";
                break;
        }

        System.out.println(nombre + " " + mensaje + " contra " + personaje.getNombre() + " causando " + dañoTotal + " de daño.");
        personaje.setPs(personaje.getPs() - dañoTotal);

        if (ps > 0 && ps <= 25) {
            int dañoUltimoAliento = (daño * 2) + agilidad;
            System.out.println(nombre + " usa Último Aliento infligiendo " + dañoUltimoAliento + " de daño adicional.");
            personaje.setPs(personaje.getPs() - dañoUltimoAliento);
        }
    }
}
