package personajes;

import razas.Raza;
import enemigos.Enemigo;

public class Personaje {
    protected String nombre;
    protected int ps;
    protected int armor;
    protected int DañoFisico;
    protected int DañoMagico;
    protected int baseDamage;
    protected int agilidad;
    protected Raza raza;

    public void setRaza(Raza raza) {
        this.raza = raza;
        if (this.raza != null) {
            raza.aplicaRaciales(this);
        }
    }
    public Raza getRaza() {
        return raza;
    }
    //constructor
    public Personaje(String nombre,int ps, int baseDamage, int armor, int dañoFisico, int dañoMagico ,int agilidad){
        this.nombre = nombre;
        this.ps = ps;
        this.armor = armor;
        this.DañoFisico = dañoFisico;
        this.DañoMagico = dañoMagico;
        this.agilidad = agilidad;
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
    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public int getDañoFisico() {
        return DañoFisico;
    }
    public void setDañoFisico(int dañoFisico) {
        DañoFisico = dañoFisico;
    }
    public int getDañoMagico() {
        return DañoMagico;
    }
    public void setDañoMagico(int dañoMagico) {
        DañoMagico = dañoMagico;
    }
    public int getAgilidad() {
        return agilidad;
    }
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    //metodos adicionales si es necesario
    //metodo ataque
    public void usarAtaque(int opcion, Enemigo enemigo){
        System.out.println(nombre + " contra " + enemigo.getNombre());
        enemigo.setPs(enemigo.getPs() - baseDamage);
    }
    public void usarHabilidadRacial(Enemigo enemigo){
        if(raza != null){
            raza.habilidadRacial(this, enemigo);
        }else{
            System.out.println(nombre + " no tiene raza asignada y no puede usar habilidad racial.");
        }
    }
    public void mostrarAtaque () {
        System.out.println("1. palmada");
        System.out.println("2. puño de 1 pulgada");
        System.out.println("3. patada alta");
        System.out.println("4. bloque de puntos vitales");
        System.out.println("5. Habilidad Racial");
    }
    //toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Clase: " + getClass().getSimpleName() + "\n Raza: " + (raza != null ? raza.getNombre() : "Sin raza") + "\n PS: " + ps + "\n Daño base: " + baseDamage + "\n Armor: " + armor + "\n Daño Físico: " + DañoFisico + "\n Daño Mágico: " + DañoMagico + "\n Agilidad: " + agilidad;
    }
}