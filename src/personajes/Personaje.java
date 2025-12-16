package personajes;

import razas.Raza;
import enemigos.Enemigo;
import game.Estado;
import java.util.ArrayList;
import items.Item;

public class Personaje {
    protected String nombre;
    protected int ps;
    protected int armor;
    protected int DañoFisico;
    protected int DañoMagico;
    protected int baseDamage;
    protected int agilidad;
    protected Raza raza;
    protected int nivel = 1;
    protected int experiencia = 0;
    protected int experienciaNecesaria = 100;
    protected Estado estadoActual = Estado.NINGUNO;
    protected int turnosRestantes = 0;
    protected ArrayList<Item> inventario;

    public void setRaza(Raza raza) {
        this.raza = raza;
        if (this.raza != null) {
            raza.aplicaRaciales(this);
        }
    }

    public Raza getRaza() {
        return raza;
    }

    // constructor
    public Personaje(String nombre, int ps, int baseDamage, int armor, int dañoFisico, int dañoMagico, int agilidad) {
        this.nombre = nombre;
        this.ps = ps;
        this.armor = armor;
        this.DañoFisico = dañoFisico;
        this.DañoMagico = dañoMagico;
        this.agilidad = agilidad;
        this.baseDamage = baseDamage;
        // Aquí inicializamos el inventario como una lista vacía
        this.inventario = new ArrayList<>();
    }

    // getters y setters
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

    // Método para recibir daño aplicando armadura
    public void recibirDaño(int dañoTotal) {
        if (armor > 0) {
            int dañoArmor = (int)(dañoTotal * 0.70);
            int dañoVida = (int)(dañoTotal * 0.30);
            
            armor = Math.max(0, armor - dañoArmor);
            ps -= dañoVida;
            
            System.out.println("Armadura absorbe " + dañoArmor + " daño. Vida recibe " + dañoVida + " daño.");
        } else {
            ps -= dañoTotal;
        }
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getExperienciaNecesaria() {
        return experienciaNecesaria;
    }

    public void setExperienciaNecesaria(int experienciaNecesaria) {
        this.experienciaNecesaria = experienciaNecesaria;
    }

    public Estado getEstado() {
        return estadoActual;
    }

    public void setEstado(Estado estado) {
        this.estadoActual = estado;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    // metodos adicionales si es necesario
    // metodo ataque
    public void usarAtaque(int opcion, Enemigo enemigo) {
        System.out.println(nombre + " contra " + enemigo.getNombre());
        enemigo.setPs(enemigo.getPs() - baseDamage);
    }

    public void usarHabilidadRacial(Enemigo enemigo) {
        if (raza != null) {
            raza.habilidadRacial(this, enemigo);
        } else {
            System.out.println(nombre + " no tiene raza asignada y no puede usar habilidad racial.");
        }
    }

    public void mostrarAtaque() {
        System.out.println("1. palmada");
        System.out.println("2. puño de 1 pulgada");
        System.out.println("3. patada alta");
        System.out.println("4. bloque de puntos vitales");
        System.out.println("5. Habilidad Racial");
        System.out.println("6. Ver Stats");
        System.out.println("7. inventario");
    }

    public void mostrarStats() {
        System.out.println("\n=== STATS DE " + nombre.toUpperCase() + " ===");
        System.out.println("Nivel: " + nivel + " | XP: " + experiencia + "/" + experienciaNecesaria);
        System.out.println("PS: " + ps + " | Armor: " + armor);
        System.out.println("Daño base: " + baseDamage + " | Agilidad: " + agilidad);
        System.out.println("Raza: " + (raza != null ? raza.getNombre() : "Sin raza"));
        System.out.println("==============================\n");
    }

    public void mostrarInventario() {
    if (inventario.isEmpty()) {
        System.out.println("El inventario está vacío.");
    } else {
        System.out.println("Inventario de " + nombre + ":");
        for (int i = 0; i < inventario.size(); i++) {
            Item item = inventario.get(i);
            System.out.println((i + 1) + ". " + item.getNombre() + " - " + item.getDescripcion());
        }
    }
}

    // ganar exp
    public void ganarExperiencia(int cantidad) {
        experiencia += cantidad;
        System.out.println(nombre + " gana " + cantidad + " puntos de experiencia: ");

        if (experiencia >= experienciaNecesaria) {
            subirNivel();
        }
    }

    // metodo subir nivel
    private void subirNivel() {
        nivel++;
        experiencia -= experienciaNecesaria;
        experienciaNecesaria += 50;

        ps += 20;
        baseDamage += 5;
        agilidad += 1;

        System.out.println(nombre + " sube al nivel " + nivel + " :) ");
        System.out.println("PS: " + ps + ", Daño: " + baseDamage + ", Agilidad: " + agilidad);
    }

    public void sumarVida(double cantidad) {
        if (this.getPs()<=70) {
          this.setPs(this.getPs() + (int) (cantidad));  
        }
        
    }

    protected int calcularDañoConCritico(int dañoBase) {
        if (Math.random() < (agilidad / 50.0)) {
            System.out.println("¡¡CRÍTICO!!");
            return dañoBase * 2; // Doble daño
        }
        return dañoBase;
    }
    public void aplicarEstado (Estado estado) {
        estadoActual = estado;
        turnosRestantes = estado.getDuracion();
        System.out.println("¡Has sido afectado por " + estadoActual + "!");
    }

    public void procesarEfectos() {
        if (estadoActual != Estado.NINGUNO) {
            int daño = estadoActual.getDañoPorTurno();
            if (daño > 0) {
                ps -= daño;
                System.out.println(nombre + " " + estadoActual.getMensaje() + " (-" + daño + " PS)");
            } else {
                System.out.println(nombre + " " + estadoActual.getMensaje());
            }
            
            turnosRestantes--;
            
            if (turnosRestantes <= 0) {
                System.out.println("El efecto de " + estadoActual + " ha terminado.");
                estadoActual = Estado.NINGUNO;
            }
        }
    }
    public void agregarItem(Item item){
         if (item != null) {
        inventario.add(item);
        System.out.println("Se ha agregado el item: " + item.getNombre() + " al inventario de " + nombre);
    } else {
        System.out.println("No se puede agregar un item nulo al inventario.");
    }
    }
    // toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Clase: " + getClass().getSimpleName() + "\n Raza: "
                + (raza != null ? raza.getNombre() : "Sin raza") + "\n PS: " + ps + "\n Daño base: " + baseDamage
                + "\n Armor: " + armor + "\n Daño Físico: " + DañoFisico + "\n Daño Mágico: " + DañoMagico
                + "\n Agilidad: " + agilidad;
    }
}