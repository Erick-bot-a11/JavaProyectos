package Biblioteca;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre,direccion,telefono,fechaNacimiento,fechaInscripcion,fechaVigencia;

    public Usuario(String nombre, String direccion, String telefono, String fechaNacimiento, String fechaInscripcion, String fechaVigencia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaVigencia = fechaVigencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }
    
    
}
