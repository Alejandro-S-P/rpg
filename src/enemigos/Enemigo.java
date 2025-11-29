package enemigos;

public class Enemigo {
    //Atributos
    protected String nombre;
    protected int ps;
    protected int daño;
    protected String arma;

    //constructor
    public Enemigo(String nombre, int ps, int daño, String arma){
        this.nombre = nombre;
        this.ps = ps;
        this.daño = daño;
        this.arma = arma;
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

    //metodos adicionales si es necesario
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPS: " + ps + "\nDaño: " + daño + "\nArma: " + arma;
    }
}
