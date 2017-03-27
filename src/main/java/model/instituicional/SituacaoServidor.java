package model.instituicional;

/**
 * Created by Dayvson on 26/03/2017.
 */
public enum SituacaoServidor {
    NORMAL("Normal"), FERIAS("Férias"), AFASTADO("Afastado"), LICENSA("Licensa");

    private String situacao;

    SituacaoServidor(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return situacao;
    }
}