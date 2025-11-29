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



        // Pedir clase (con filtro)
        int opcionClase = readInt(sc, "Seleccione la clase (1. Arquero, 2. Samurai, 3. Guerrero, 4. Rogue, 5. Mago, 6. Monje):", 1, 6);

        Personaje personaje;
        switch (opcionClase) {
            case 1:
                personaje = new Archer(nombre, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase);
                break;
            case 2:
                personaje = new Samurai(nombre, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase);
                break;
            case 3:
                personaje = new Warrior(nombre, opcionClase, opcionClase);
                break;
            case 4:
                personaje = new Rogue(nombre, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase);
                break;
            case 5:
                personaje = new Mage(nombre, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase);
                break;
            case 6:
                personaje = new Monje(nombre, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase, opcionClase);
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


  