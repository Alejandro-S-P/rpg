package game;

import java.util.Random;
import enemigos.*;

public class GeneradorEnemigos {
    // declaramos random
    private static final Random ran = new Random();

    // probabilidad para cada categoria de enemigo
    private static final int Probalidad_Comun = 70;
    private static final int Probalidad_Raro = 22;
    private static final int Probalidad_Elite = 8;

    // enum para clasificar enemigos por rareza
    private enum Categoria {
        COMUN, RARO, ELITE
    }

    // metodo elige categoria
    private static Categoria elegirCategoria() {
        // genera un numero aleatorio y la suma total de probalilidad
        int roll = ran.nextInt(Probalidad_Comun + Probalidad_Raro + Probalidad_Elite);

        // eleccion segun el random
        if (roll < Probalidad_Comun)
            return Categoria.COMUN;

        else if (roll < Probalidad_Raro + Probalidad_Comun)
            return Categoria.RARO;

        else
            return Categoria.ELITE;
    }

    // metodo genera enemigo
    public static Enemigo generarEnemigoAleatorio(int nivelJugador, String entorno){
      //estipulamos categorioa
        Categoria cat = elegirCategoria();
      Enemigo enemigo=null;
      //sgun la categoria , genemramo un enemigo
      switch (cat) {
        case COMUN:
            enemigo = generarComun(entorno);
            break;
        case RARO:
            enemigo = generarRaro(entorno);
            break;
        case ELITE:
            enemigo = generarElite(entorno);
            break;
      } 
      //Variamos sus atributos para que no sean iguales
    //escalamos sus atributos segun el nivel del jugador
    //devolvemos el enemigo final 
    aplicarVariacionAtributos(enemigo);
    aplicarEscaladoPorNivel(enemigo, nivelJugador);
    return enemigo; 
    }
    //generar enemigo comun
    private static Enemigo generarComun(String entorno){
        int opcion = ran.nextInt(3); // elige entre 3 enemigos comunes
        switch (opcion) {
            case 0: return new EsqueletoArquero("Esqueleto arquero", 80, 15, "Arco Roto", 6);
            case 1: return new EsqueletoWarior("Esqueleto Warrior", 90, 18, "Espada Rota", 5);
            default: return new EsqueletoNinja("Esqueleto Ninja", 75, 14, "Kusarigama oxidada", 8);            
        }
    }
    //generar enemigo raro
    private static Enemigo generarRaro(String entorno){
        int opcion = ran.nextInt(2); // eligen entre 2 enemigos raros
        switch (opcion) {
            case 0: return new NoMuertoGuerrero("No Muerto Guerrero", 110, 20, "Espada Maldita", 6);
            default: return new NoMuertoMago("No Muerto Mago", 95, 22, "Centro sombrio", 5);            
        }
    }
    //generar enemigo elite
    private static Enemigo generarElite(String entorno){
        return new NoMuertoNigromante("No Muerto Nigromate", 120,24, "Libro de los Lamentos", 10);
    }
    // Aplica variaciones aleatorias a los atributos del enemigo
    private static void aplicarVariacionAtributos(Enemigo enemigo) {
        // Guardamos los valores base
        int ps = enemigo.getPs();
        int daño = enemigo.getDaño();

        // Variamos PS entre -10% y +10%
        int variacionPs = (int)(ps * (ran.nextDouble() * 0.20 - 0.10));
        // Variamos daño entre -15% y +15%
        int variacionDaño = (int)(daño * (ran.nextDouble() * 0.30 - 0.15));

        // Aplicamos las variaciones asegurando que nunca sean menores que 1
        enemigo.setPs(Math.max(1, ps + variacionPs));
        enemigo.setDaño(Math.max(1, daño + variacionDaño));

        // Asignamos agilidad aleatoria entre 4 y 8
        enemigo.setAgilidad(4 + ran.nextInt(5));
    }
    // Escala atributos del enemigo según el nivel del jugador
    private static void aplicarEscaladoPorNivel(Enemigo enemigo, int nivelJugador) {
        // Si el jugador está en nivel 1, no escalamos nada
        if (nivelJugador <= 1) return;

        // Factor de escalado: +5% por nivel, máximo +50%
        double factor = 1.0 + Math.min(0.05 * (nivelJugador - 1), 0.50);

        // Escalamos PS y daño
        enemigo.setPs((int)(enemigo.getPs() * factor));
        enemigo.setDaño((int)(enemigo.getDaño() * factor));

        // Escalamos agilidad suavemente según nivel
        enemigo.setAgilidad((int)Math.max(1, enemigo.getAgilidad() * (0.9 + 0.02 * nivelJugador)));
    }

    
    

}
