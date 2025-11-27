package personajes;

public class mage {
    //atributos
    private String nombre;
    private int ps;
    private int baseDamage;
    //constructor
    public mage(String nombre,int ps, int baseDamage){
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
    //metodos
    public void proyectilMagico(){
        System.out.println(getNombre()+" infligio "+getBaseDamage()+" puntos de daño");
    }
    public void bolaFuego(int dañoExtra){
        baseDamage+=dañoExtra;
        System.out.println(getNombre()+" inflingio "+getBaseDamage()+" puntos de daño");
        //1 de daño por cada turno
    }
    public void copoHielo(){
        System.out.println(getNombre()+" infligio "+getBaseDamage()+30+" puntos de daño");
        //stunea 2 turnos
    }
    public void lluviaEstrellas(){
        System.out.println(getNombre()+" inflingio "+getBaseDamage()+50+" puntos de daño");//a todos los enemigos
    }
    
    


}
