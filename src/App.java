import java.util.Scanner;

import enemigos.Enemigo;
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
        //crear el Scanner
        //empiezan las interacciones
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a rpg-java!");
        System.out.println("Vamos a crear tu personaje.");


        // Pedir nombre
        System.out.println("Ingrese el nombre de su personaje:");
        String nombre = sc.nextLine();



        // Pedir clase (con filtro)
        int opcionClase = readInt(sc, "Seleccione la clase (1. Arquero, 2. Samurai, 3. Guerrero, 4. Rogue, 5. Mago, 6. Monje):", 1, 6);

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
                personaje = new Monje(nombre, 100, 20
                );
                break;
            default:
                System.out.println("Opción no válida. Se asignará Guerrero por defecto.");
                personaje = new Warrior(nombre, 120, 20);
                break;
        }

        // Pedir raza (con filtro)
        int opcionRaza = readInt(sc, "Seleccione la raza (1. Elfo, 2. Enano, 3. Alien, 4. Humano, 5. Licantropo, 6. Orco):", 1, 6);
        Raza raza;
        switch (opcionRaza) {
            case 1: raza = new Elfo(); break;
            case 2: raza = new Enano(); break;
            case 3: raza = new Alien(); break;
            case 4: raza = new Humano(); break;
            case 5: raza = new Licantropo(); break;
            case 6: raza = new Orco(); break;
            default:
                System.out.println("Opción no válida. Se asignará Elfo por defecto.");
                raza = new Elfo();
                break;
        }
        personaje.setRaza(raza);

        // Mostrar personaje creado
        System.out.println("Personaje creado:");
        System.out.println(personaje.toString());

        //aparece un enemigo
        System.out.println("¡Un enemigo aparece!");
        Enemigo EsqueletoArquero = new Enemigo("Esqueleto Arquero", 80, 15, "Arco Roto");
        System.out.println("Te enfrentas a: " + EsqueletoArquero.getNombre() + " con " + EsqueletoArquero.getPs() + " PS.");
        //bucle de combate simple
        while (personaje.getPs() > 0 && EsqueletoArquero.getPs() > 0) {
            
            personaje.mostrarAtaque();
            int opcionAtaque = readInt(sc, "Selecciona una opción (1-5):", 1, 5);
            personaje.usarAtaque(opcionAtaque, EsqueletoArquero);
            

            if (EsqueletoArquero.getPs() <= 0) {
                System.out.println("¡Has derrotado al " + EsqueletoArquero.getNombre() + "!");
                break;
            }

            // Ataque del enemigo
            System.out.println(EsqueletoArquero.getNombre() + " ataca a " + personaje.getNombre() + " causando " + EsqueletoArquero.getDaño() + " de daño.");
            personaje.setPs(personaje.getPs() - EsqueletoArquero.getDaño());
            System.out.println("PS restante de " + personaje.getNombre() + ": " + personaje.getPs());
            
            if (personaje.getPs() <= 0) {
                System.out.println("¡Has sido derrotado por el " + EsqueletoArquero.getNombre() + "!");
            }
        }

        
        //cerrar el Scanner
        sc.close();
    }
    // Método para leer un entero con filtro
    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            String line = sc.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val < min || val > max) {
                    System.out.println("Ingrese un número entre " + min + " y " + max + ".");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

}


  