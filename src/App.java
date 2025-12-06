import java.util.Scanner;

import enemigos.Enemigo;
import game.Estado;
import game.ReadInt;
import personajes.Archer;
import personajes.Mage;
import personajes.Monje;
import personajes.Personaje;
import personajes.Rogue;
import personajes.Samurai;
import personajes.Warrior;
import razas.Alien;
import razas.Elfo;
import razas.Enano;
import razas.Humano;
import razas.Licantropo;
import razas.Orco;
import razas.Raza;

public class App {
    public static void main(String[] args) throws Exception {
        // crear el Scanner
        // empiezan las interacciones
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a rpg-java!");
        System.out.println("Vamos a crear tu personaje.");

        // Pedir nombre
        System.out.println("Ingrese el nombre de su personaje:");
        String nombre = sc.nextLine();

        // Pedir clase (con filtro)
        int opcionClase = ReadInt.readInt(sc,
                "Seleccione la clase (1. Archer, 2. Samurai, 3. Warrior, 4. Rogue, 5. Mage, 6. Monje):", 1, 6);

        Personaje personaje;
        switch (opcionClase) {
            case 1:
                personaje = new Archer(nombre, 100, 20);
                break;
            case 2:
                personaje = new Samurai(nombre, 100, 20);
                break;
            case 3:
                personaje = new Warrior(nombre, 100, 20);
                break;
            case 4:
                personaje = new Rogue(nombre, 100, 20);
                break;
            case 5:
                personaje = new Mage(nombre, 100, 20);
                break;
            case 6:
                personaje = new Monje(nombre, 100, 20);
                break;
            default:
                System.out.println("Opción no válida. Se asignará Guerrero por defecto.");
                personaje = new Warrior(nombre, 120, 20);
                break;
        }

        // Pedir raza (con filtro)
        int opcionRaza = ReadInt.readInt(sc,
                "Seleccione la raza (1. Elfo, 2. Enano, 3. Alien, 4. Humano, 5. Licantropo, 6. Orco):", 1, 6);
        Raza raza;
        switch (opcionRaza) {
            case 1:
                raza = new Elfo();
                break;
            case 2:
                raza = new Enano();
                break;
            case 3:
                raza = new Alien();
                break;
            case 4:
                raza = new Humano();
                break;
            case 5:
                raza = new Licantropo();
                break;
            case 6:
                raza = new Orco();
                break;
            default:
                System.out.println("Opción no válida. Se asignará Elfo por defecto.");
                raza = new Elfo();
                break;
        }
        personaje.setRaza(raza);

        // Mostrar personaje creado
        System.out.println("Personaje creado:");
        System.out.println(personaje.toString());
        int contador=0;
        while (personaje.getPs()>0) {
        
        // aparece un enemigo
        Enemigo enemigo;
        if (contador > 0 && contador % 10 == 0) {
            // BOSS cada 10 kills - dragón aleatorio
            System.out.println("\n🐉 ¡¡UN DRAGON BOSS APARECE!! 🐉");
            int vidaBoss = 150 + (personaje.getNivel() * 25);
            int dañoBoss = 20 + (personaje.getNivel() * 4);
            
            int tipoDragon = (int)(Math.random() * 4) + 1;
            switch (tipoDragon) {
                case 1:
                    enemigo = new enemigos.DragonFuego("Dragon de Fuego", vidaBoss, dañoBoss, "Llamas", 10);
                    break;
                case 2:
                    enemigo = new enemigos.DragonHielo("Dragon de Hielo", vidaBoss, dañoBoss, "Escarcha", 10);
                    break;
                case 3:
                    enemigo = new enemigos.DragonOscuro("Dragon Oscuro", vidaBoss, dañoBoss, "Sombras", 10);
                    break;
                default:
                    enemigo = new enemigos.DragonBrutal("Dragon Brutal", vidaBoss, dañoBoss, "Garras", 10);
                    break;
            }
        } else {
            System.out.println("¡Un enemigo aparece!");
            enemigo = game.GeneradorEnemigos.generarEnemigoAleatorio(personaje.getNivel(), "bosque");
        }
        System.out.println("Te enfrentas a: " + enemigo.getNombre() + " con " + enemigo.getPs() + " PS.");

        // bucle de combate simple
        while (personaje.getPs() > 0 && enemigo.getPs() > 0) {
            System.out.println("\n--- Nueva ronda de combate ---");

            // Probabilidad de que el jugador ataque primero
            double probJugador = personaje.getAgilidad() /
                    (double) (personaje.getAgilidad() + enemigo.getAgilidad());
            boolean turnoJugadorPrimero = Math.random() < probJugador;

            if (turnoJugadorPrimero) {
                // Procesar efectos de estado
                personaje.procesarEfectos();
                
                // Si está congelado, pierde el turno
                if (personaje.getEstado() == Estado.CONGELACION) {
                    System.out.println("¡" + personaje.getNombre() + " está congelado y no puede atacar!");
                } else {
                    // turno del jugador
                    int opcionAtaque;
                    do {
                        personaje.mostrarAtaque();
                        opcionAtaque = ReadInt.readInt(sc, "", 1, 6);
                        if (opcionAtaque == 6) {
                            personaje.mostrarStats();
                        }
                    } while (opcionAtaque == 6);
                    personaje.usarAtaque(opcionAtaque, enemigo);

                    if (enemigo.getPs() <= 0) {
                        System.out.println("¡Has derrotado al " + enemigo.getNombre() + "!");
                        contador++;
                        personaje.ganarExperiencia(25);
                        personaje.sumarVida(personaje.getPs()*0.50);
                        break;
                    }
                }

                // turno del enemigo
                enemigo.enemigoAtacar(personaje, enemigo);
                System.out.println("PS de " + personaje.getNombre() + ": " + personaje.getPs());
                if (personaje.getPs() <= 0) {
                    System.out.println("¡Has sido derrotado por el " + enemigo.getNombre() + "!");
                    break;
                }

            } else {
                // turno del enemigo primero
                enemigo.enemigoAtacar(personaje, enemigo);
                System.out.println("PS de " + personaje.getNombre() + ": " + personaje.getPs());
                if (personaje.getPs() <= 0) {
                    System.out.println("¡Has sido derrotado por el " + enemigo.getNombre() + "!");
                    break;
                }

                // turno del jugador
                // Procesar efectos de estado
                personaje.procesarEfectos();
                
                // Si está congelado, pierde el turno
                if (personaje.getEstado() == Estado.CONGELACION) {
                    System.out.println("¡" + personaje.getNombre() + " está congelado y no puede atacar!");
                } else {
                    int opcionAtaque;
                    do {
                        personaje.mostrarAtaque();
                        opcionAtaque = ReadInt.readInt(sc, "Elige un ataque 1-6: ", 1, 6);
                        if (opcionAtaque == 6) {
                            personaje.mostrarStats();
                        }
                    } while (opcionAtaque == 6);
                    personaje.usarAtaque(opcionAtaque, enemigo);

                    if (enemigo.getPs() <= 0) {
                        System.out.println("¡Has derrotado al " + enemigo.getNombre() + "!");
                        contador++;
                        personaje.ganarExperiencia(25);
                        personaje.sumarVida(personaje.getPs()*0.50);
                        break;
                    }
                }

            }
        } // fin bucle
        
        }//fin bucle principal
        System.out.println("game over (te estan comiendo los gusanos)");
        System.out.println("Llegaste al nivel: " + personaje.getNivel()+" mataste: "+contador);
        // cerrar el Scanner
        sc.close();
    }
    // Método para leer un entero con filtro

}
