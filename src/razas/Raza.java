package razas;
import enemigos.Enemigo;
import personajes.Personaje;
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
    public void aplicaRaciales(Personaje personaje){
        // Aplicar bonificaciones a PS y daño base
        personaje.setPs(personaje.getPs()+fuerza/2+ destreza/4);
        personaje.setBaseDamage(personaje.getBaseDamage()+fuerza/3 + personaje.getDañoFisico()/1+personaje.getDañoMagico()/1);
        personaje.setArmor(personaje.getArmor()+fuerza);
        personaje.setDañoFisico(personaje.getDañoFisico()+fuerza/2+ destreza/2);
        personaje.setDañoMagico(personaje.getDañoMagico()+inteligencia/2+ destreza/2);
        personaje.setAgilidad(personaje.getAgilidad()+evasion);     
        
    }
    public void habilidadRacial(Personaje personaje, Enemigo enemigo){
        // Implementar habilidad racial específica en subclases
        System.out.println(personaje.getNombre() + " no tiene habilidad racial definida.");
    }

    @Override
    public String toString() {
        return nombre + " (Fuerza:" + fuerza + " Inteligencia:" + inteligencia + " Evasion:" + evasion + " Destreza:" + destreza + ")";
    }
    
}
