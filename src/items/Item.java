package items;
public abstract class Item {
    protected String nombre;
    protected String descripcion;
    public Item (String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public abstract void usar(personajes.Personaje p);
}
