package personajes;

import enemigos.Enemigo;

public class Rogue extends Personaje {
    //constructor
    public Rogue(String nombre,int ps, int baseDamage){
        // valores por defecto para un rogue
        super(nombre, ps, baseDamage, 2, 6, 2, 10);
    }
    // metodos
    // metodo ataque
    @Override
    public void usarAtaque(int opcion, Enemigo enemigo) {
        int dañoTotal = baseDamage;
        String mensaje = "";

        switch (opcion) {
            case 1:
                mensaje = "usa puñalada";
                break;
            case 2:
                dañoTotal += 10;
                mensaje = "usa corte de garganta";
                break;
            case 3:
                dañoTotal += 15;
                mensaje = "usa estrella ninja";
                break;
            case 4:
                dañoTotal += 20;
                mensaje = "usa ataque por la espalda";
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
        dañoTotal = calcularDañoConCritico(dañoTotal);
        System.out.println(nombre + " " + mensaje + " contra " + enemigo.getNombre() + " causando " + dañoTotal + " de daño.");
        enemigo.setPs(enemigo.getPs() - dañoTotal);
        System.out.println("PS restante de " + enemigo.getNombre() + ": " + enemigo.getPs());
    }
    @Override
    public void mostrarAtaque () {
        System.out.println("1. puñalada");
        System.out.println("2. corte de garganta");
        System.out.println("3. estrella ninja");
        System.out.println("4. ataque por la espalda");
        System.out.println("5. Habilidad Racial");
        System.out.println("6. Ver Stats");
    }
    


}
