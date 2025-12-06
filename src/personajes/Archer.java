package personajes;

import enemigos.Enemigo;

public class Archer extends Personaje {
    // constructor
    public Archer(String nombre, int ps, int baseDamage) {
        // valores por defecto para un mago
        super(nombre, ps, baseDamage, 2, 2, 6, 3);
    }

    // metodos
    // metodo ataque
    @Override
    public void usarAtaque(int opcion, Enemigo enemigo) {
        int dañoTotal = baseDamage;
        String mensaje = "";

        switch (opcion) {
            case 1:
                mensaje = "dispara flecha rápida";
                break;
            case 2:
                dañoTotal += 10;
                mensaje = "dispara flecha penetrante";
                break;
            case 3:
                dañoTotal += 15;
                mensaje = "dispara lluvia de flechas";
                break;
            case 4:
                dañoTotal += 20;
                mensaje = "dispara flecha ígnea";
                break;
            case 5:
                if (raza != null) {
                    raza.habilidadRacial(this, enemigo);
                } else {
                    System.out.println(nombre + " no tiene raza asignada.");
                }
                return;
            case 6:
                mostrarStats();
                return;
            default:
                System.out.println("Opción de ataque no válida.");
                return;
        }
        System.out.println("-----------------------------------------");
        dañoTotal=calcularDañoConCritico(dañoTotal);
        System.out.println(
                nombre + " " + mensaje + " contra " + enemigo.getNombre() + " causando " + dañoTotal + " de daño.");
        enemigo.setPs(enemigo.getPs() - dañoTotal);
        System.out.println("PS restante de " + enemigo.getNombre() + ": " + enemigo.getPs());
    }

    @Override
    public void mostrarAtaque() {
        System.out.println("1. Flecha Rapida");
        System.out.println("2. Flecha Penetrante");
        System.out.println("3. Lluvia de Flechas");
        System.out.println("4. Flecha Ignea");
        System.out.println("5. Habilidad Racial");
        System.out.println("6. Ver Stats");
    }

}
