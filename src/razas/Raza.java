package razas;

import java.util.Scanner;

public class Raza {
    protected String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int evasion;
    protected int destreza;

    public Raza(String nombre, int fuerza, int inteligencia, int evasion, int destreza) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.evasion = evasion;
        this.destreza = destreza;
    }
    public Raza(String nombre) {
        this.nombre = nombre;
    }
    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
    //otros métodos si es necesario
    public static Raza elegirRaza(Scanner sc) {
        System.out.println("Seleccione la raza (1. Elfo, 2. Enano):");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1: return new Elfo();
            case 2: return new Enano();
            default:
                System.out.println("Opción no válida. Se asignará Elfo por defecto.");
                return new Elfo();
        }
    }

    
}
