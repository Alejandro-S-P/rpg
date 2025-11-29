import java.util.Scanner;

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



        // Pedir clase
        System.out.println("Seleccione la clase (1. Arquero, 2. Samurai, 3. Guerrero, 4. Rogue, 5. Mago, 6. Monje):");
        int opcionClase = sc.nextInt();

        Personaje personaje;
        switch (opcionClase) {
            case 1:
                personaje = new Archer(nombre, 100, 15);
                break;
            case 2:
                personaje = new Samurai(nombre, 100, 15);
                break;
            case 3:
                personaje = new Warrior(nombre, 120, 20);
                break;
            case 4:
                personaje = new Rogue(nombre, 90, 30);
                break;
            case 5:
                personaje = new Mage(nombre, 80, 40);
                break;
            case 6:
                personaje = new Monje(nombre, 130, 30);
                break;
            default:
                System.out.println("Opción no válida. Se asignará Arquero por defecto.");
                personaje = new Archer(nombre, 100, 15);
                break;
        }

        // Pedir raza
        System.out.println("Seleccione la raza (1. Elfo, 2. Enan, 3.Alien, 4. humano, 5. Licantropo, 6. Orco):");
        int opcionRaza = sc.nextInt();
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
        System.out.println("Nombre: " + personaje.getNombre() );
        System.out.println("Clase: " + personaje.getClass().getSimpleName());
        System.out.println("Raza: " + personaje.getRaza().getNombre());
        System.out.println("PS: " + personaje.getPs());
        System.out.println("Daño base: " + personaje.getBaseDamage());


        sc.close();
    }
}


  