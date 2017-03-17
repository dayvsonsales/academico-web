package controller;

import model.PermissoesEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dayvson on 13/03/2017.
 */
public abstract class Controller {

    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract void init();

    public Set<PermissoesEnum> getPermissoesNecessarias() {
        Set<PermissoesEnum> permissoes = new HashSet<PermissoesEnum>();

        return permissoes;
    }

}
