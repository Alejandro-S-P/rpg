package personajes;

public class mage {
    //atributos
    private String nombre;
    private String ps;
    private String baseDamage;
    //constructor
    public mage(String nombre,String ps, String baseDamage){
        this.nombre = nombre;
        this.ps= ps;
        this.baseDamage = baseDamage;
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(String baseDamage) {
        this.baseDamage = baseDamage;
    }
    //metodos
    
    


}
