package Biblioteca;

import java.io.Serializable;

public class Prestamo implements Serializable {
    private String titulo,nombre,fechaI,fechaF;
    private int cuota;

    public Prestamo(String titulo, String nombre, String fechaI, String fechaF, int cuota) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.cuota = cuota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaI() {
        return fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public int getCuota() {
        return cuota;
    }
    
}
