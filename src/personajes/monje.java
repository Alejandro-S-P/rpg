package personajes;

public class monje {
    private String nombre;
    private int ps;
    private int baseDamage;
    //constructor
    public monje(String nombre,int ps, int baseDamage){
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
}
