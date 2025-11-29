package personajes;

import razas.Raza;

public class Personaje {
    protected String nombre;
    protected int ps;
    protected int baseDamage;
    protected Raza raza;

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    //constructor
    public Personaje(String nombre,int ps, int baseDamage){
        this.nombre = nombre;
        this.ps = ps;
        this.baseDamage = baseDamage;
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
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public Raza getRaza() {
        return raza;
    }
    
    


    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Clase: " + getClass().getSimpleName() + ", Raza: " + (raza != null ? raza.getNombre() : "Sin raza") + ", PS: " + ps + ", Daño base: " + baseDamage;
    }
}