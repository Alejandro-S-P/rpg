import personajes.archer;
import personajes.mage;
import personajes.rogue;
import personajes.warrior;

public class App {
    public static void main(String[] args) throws Exception {
        mage m1 = new mage("gandalf", 100, 20);
        m1.proyectilMagico();
        m1.bolaFuego(20);
        m1.copoHielo();
        m1.lluviaEstrellas();
}
}
