package enemigos;

import personajes.Personaje;

public class Enemigo {
    //Atributos
    protected String nombre;
    protected int ps;
    protected int daño;
    protected String arma;
    protected int agilidad;

    //constructor
    public Enemigo(String nombre, int ps, int daño, String arma, int agilidad){
        this.nombre = nombre;
        this.ps = ps;
        this.daño = daño;
        this.arma = arma;
        this.agilidad = agilidad;
    }

    //getters y setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
    public String getArma() {
        return arma;
    }
    public void setArma(String arma) {
        this.arma = arma;
    }
    public int getAgilidad() {
        return agilidad;
    }
    public void setAgilidad(int agilidad){
        this.agilidad = agilidad;
    }
    //metodos adicionales si es necesario
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPS: " + ps + "\nDaño: " + daño + "\nArma: " + arma+"\nAgilidad: "+ agilidad;
    }
    public void enemigoAtacar(Personaje personaje, Enemigo enemigo){
        // Calcular daño con influencia de agilidad
        int dañoTotal = enemigo.getDaño() + (enemigo.getAgilidad() / 2);
        if (enemigo.getPs()<=25) {
            int dañoUltimoAliento = (enemigo.getDaño() * 2) + enemigo.getAgilidad();
            System.out.println(enemigo.getNombre()+" uso ultimo aliento inflinjiendo: "+dañoUltimoAliento+" de daño");
            personaje.recibirDaño(dañoUltimoAliento);
            return;  // Termina el turno, no hace ataque normal
        }
        System.out.println(enemigo.getNombre()+" ataco a "+personaje.getNombre()+" restandole: "+dañoTotal);
        personaje.recibirDaño(dañoTotal);
        System.out.println("Los PS restantes de "+personaje.getNombre()+" son: "+personaje.getPs());
    }

    
}
