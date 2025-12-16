package personajes;

import enemigos.Enemigo;

public class Samurai extends Personaje {
    //constructor
    public Samurai(String nombre,int ps, int baseDamage){
        // valores por defecto para un samurai
        super(nombre, ps, baseDamage, 5, 8, 2, 6);
    }
    // metodos
    // metodo ataque
    @Override
    public void usarAtaque(int opcion, Enemigo enemigo) {
        int dañoTotal = baseDamage;
        String mensaje = "";

        switch (opcion) {
            case 1:
                mensaje = "usa corte de katana";
                break;
            case 2:
                dañoTotal += 10;
                mensaje = "usa corte vertical de katana";
                break;
            case 3:
                dañoTotal += 15;
                mensaje = "usa ataque de las sombras";
                break;
            case 4:
                dañoTotal += 20;
                mensaje = "usa clones de sombras";
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
            case 7:
                mostrarInventario();
                return;
            default:
                System.out.println("Opción de ataque no válida.");
                return;
        }
        System.out.println("-----------------------------------------");
        dañoTotal = calcularDañoConCritico(dañoTotal);
        System.out.println(nombre + " " + mensaje + " contra " + enemigo.getNombre() + " causando " + dañoTotal + " de daño.");
        enemigo.setPs(enemigo.getPs() - dañoTotal);
        System.out.println("PS restante de " + enemigo.getNombre() + ": " + enemigo.getPs());
    }
    @Override
    public void mostrarAtaque () {
        System.out.println("1. corte de katana");
        System.out.println("2. corte vertical de katana");
        System.out.println("3. ataque de las sombras");
        System.out.println("4. clones de sombras");
        System.out.println("5. Habilidad Racial");
        System.out.println("6. Ver Stats");
        System.out.println("7. ver inventario");
    }
}
