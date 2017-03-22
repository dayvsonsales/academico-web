/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.centroacademico.Membro;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports.Relatorio;
import repository.MembroRepository;

/**
 * @author Dayvson
 */
public class RelatorioMembro extends Relatorio {

    public RelatorioMembro() {
        super.relatorio = "reportMembro2.jasper";
    }

    public void gerarRelatorio(Map parametros) throws JRException, IOException {

        super.parametros = parametros;

        List<Membro> listaMembro = (ArrayList<Membro>) new MembroRepository(Membro.class).all();

        ds = new JRBeanCollectionDataSource(listaMembro, false);

        imprimirRelatorio();
    }

}
