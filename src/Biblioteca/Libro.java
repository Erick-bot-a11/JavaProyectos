
package Biblioteca;

import java.io.Serializable;

public class Libro implements Serializable {//Le indicamos que guardara objetos en Archivos Binarios
    private String codigo,titulo,autores,isbn,editorial,año;
    private int copias;

    public Libro(String codigo, String titulo, String autores, String isbn, String editorial, String año,int copias) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.editorial = editorial;
        this.año = año;
        this.copias=copias;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutores() {
        return autores;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getEditorial() {
        return editorial;
    }
    public String getAño(){
        return año;
    }
    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
