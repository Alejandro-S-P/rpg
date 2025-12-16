package items;

import personajes.Personaje;

public class PocionSalud extends Item {

    public PocionSalud(String nombre, String descripcion) {
        super(nombre, descripcion);
        
    }

    @Override
    public void usar(Personaje p) {
    p.setPs(p.getPs()+50);
    System.out.println("usaste la pocion de salud "+50+" de salud");
    System.out.println(p.getPs());
    }
}
