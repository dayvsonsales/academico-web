/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.impl;

import model.instituicional.Discente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports.Relatorio;
import repository.DiscenteRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Dayvson
 */
public class RelatorioCurso extends Relatorio {

    public RelatorioCurso() {
        super.relatorio = "reportAlunosCurso.jasper";
    }

    public void gerarRelatorio(Map parametros) throws JRException, IOException {

        super.parametros = parametros;

        List<Discente> listaDiscentesPorCurso = new DiscenteRepository().buscarPorCurso((Integer) parametros.get("curso_id"));

        ds = new JRBeanCollectionDataSource(listaDiscentesPorCurso, false);

        imprimirRelatorio();
    }

}
