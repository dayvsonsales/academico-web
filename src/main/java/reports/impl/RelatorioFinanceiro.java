/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.impl;

import model.centroacademico.MovimentacaoFinanceira;
import model.instituicional.Discente;
import model.patrimonio.Movimentacao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports.Relatorio;
import repository.DiscenteRepository;
import repository.FinanceiroRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Dayvson
 */
public class RelatorioFinanceiro extends Relatorio {

    public RelatorioFinanceiro() {
        super.relatorio = "reportFinanceiro.jasper";
    }

    public void gerarRelatorioFinanceiroPorMes(Map parametros) throws JRException, IOException {

        super.parametros = parametros;

        List<MovimentacaoFinanceira> lista = new FinanceiroRepository().buscarPorMes((Integer) parametros.get("mes"));

        ds = new JRBeanCollectionDataSource(lista, false);

        imprimirRelatorio();
    }
}
