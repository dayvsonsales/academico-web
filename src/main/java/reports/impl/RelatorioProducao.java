/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.impl;

import model.centroacademico.MovimentacaoFinanceira;
import model.producao.Projeto;
import model.producao.Publicacao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports.Relatorio;
import repository.FinanceiroRepository;
import repository.ProjetoRepository;
import repository.PublicacaoRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Dayvson
 */
public class RelatorioProducao extends Relatorio {

    public RelatorioProducao() {
        super.relatorio = "reportProjetos.jasper";
    }

    public void gerarRelatorioProjetos(Map parametros) throws JRException, IOException {

        super.parametros = parametros;

        List<Projeto> lista = new ProjetoRepository().all();

        ds = new JRBeanCollectionDataSource(lista, false);

        imprimirRelatorio();
    }

    public void gerarRelatorioPublicacao(Map parametros) throws JRException, IOException {

        super.parametros = parametros;
        super.relatorio = "reportPublicacao.jasper";

        List<Publicacao> lista = new PublicacaoRepository().all();

        ds = new JRBeanCollectionDataSource(lista, false);

        imprimirRelatorio();
    }
}