package controller;

import java.io.Serializable;

/**
 * Created by Dayvson on 13/03/2017.
 */
public abstract class Controller implements Serializable {

    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract void init();

}
