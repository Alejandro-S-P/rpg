import personajes.archer;
import personajes.mage;
import personajes.rogue;
import personajes.warrior;
import razas.elfo;

public class App {
    public static void main(String[] args) throws Exception {
        mage m1 = new mage("gandalf", 100, 20);
        m1.proyectilMagico();
        m1.bolaFuego(20);
        m1.copoHielo();
        m1.lluviaEstrellas();
        elfo e1 = new elfo("legolas", 50, 80, 40, 90);
        e1.saludar();
}
}
