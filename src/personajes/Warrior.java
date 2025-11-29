package personajes;

import enemigos.Enemigo;

public class Warrior extends Personaje {
    //constructor
    public Warrior(String nombre,int ps, int baseDamage){
        // valores por defecto para un guerrero
        super(nombre, ps, baseDamage, 6, 10, 2, 3);
    }
   // metodos
    // metodo ataque
    @Override
    public void usarAtaque(int opcion, Enemigo enemigo) {
        int dañoTotal = baseDamage;
        String mensaje = "";

        switch (opcion) {
            case 1:
                mensaje = "usa espadazo";
                break;
            case 2:
                dañoTotal += 10;
                mensaje = "usa corte lateral";
                break;
            case 3:
                dañoTotal += 15;
                mensaje = "usa espadazo en salto";
                break;
            case 4:
                dañoTotal += 20;
                mensaje = "usa cadenas del aberno";
                break;
            case 5:
                if (raza != null) {
                    raza.habilidadRacial(this, enemigo);
                } else {
                    System.out.println(nombre + " no tiene raza asignada.");
                }
            default:
                System.out.println("Opción de ataque no válida.");
                return;
        }
        System.out.println("-----------------------------------------");
        System.out.println(nombre + " " + mensaje + " contra " + enemigo.getNombre() + " causando " + dañoTotal + " de daño.");
        enemigo.setPs(enemigo.getPs() - dañoTotal);
        System.out.println("PS restante de " + enemigo.getNombre() + ": " + enemigo.getPs());
    }
    @Override
    public void mostrarAtaque () {
        System.out.println("1. espadazo");
        System.out.println("2. corte lateral");
        System.out.println("3. espadazo en salto");
        System.out.println("4. cadenas del aberno");
        System.out.println("5. Habilidad Racial");
    }

}

