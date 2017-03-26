package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Dayvson on 26/03/2017.
 */
@ManagedBean
@RequestScoped
public class Sistema {

    private String periodoAtual;

    public Sistema(){
        this.periodoAtual = "2016.2";
    }

    public String getPeriodoAtual() {
        return periodoAtual;
    }

    public void setPeriodoAtual(String periodoAtual) {
        this.periodoAtual = periodoAtual;
    }
}
