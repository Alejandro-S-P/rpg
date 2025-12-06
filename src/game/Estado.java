package game;

public enum Estado {
    NINGUNO(0, 0, ""),
    VENENO(3, 5, "sufre daño por veneno"),
    QUEMADURA(5, 3, "sufre daño por quemadura"),
    CONGELACION(0, 2, "esta congelado"),
    SANGRADO(4, 4, "sufre daño por sangrado");

    private int dañoPorTurno;
    private int duracion;
    private String mensaje;

    Estado(int dañoPorTurno, int duracion, String mensaje) {
        this.dañoPorTurno = dañoPorTurno;
        this.duracion = duracion;
        this.mensaje = mensaje;
    }

    public int getDañoPorTurno() {
        return dañoPorTurno;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getMensaje() {
        return mensaje;
    }
}
