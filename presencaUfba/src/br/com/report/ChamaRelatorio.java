package br.com.report;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dados.Aluno;
import br.com.dados.Turma;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ChamaRelatorio {
	
	public ChamaRelatorio(Turma turma, List<Aluno> aluno, String dir) throws IOException, JRException {
		//pega o caminho da pasta do projeto
	  	String caminho = System.getProperty("user.dir");  
	  	caminho.replace('\\', '/');
	  	dir.replace('\\', '/');
	  	
	  	
	  //Cria e abre o arquivo properties
	    //Properties arq = new Properties();
	    //FileInputStream file = new FileInputStream(caminho + "/src/relatorio/cabecalho.properties");
	    //arq.load(file);
	    
	    Map<String, Object> mapa = new HashMap<String, Object>(); //cria o mapa
	    Cabecalho dados_cabecalho = new Cabecalho();
	    dados_cabecalho.setDepartamento(null);
	    dados_cabecalho.setDisciplina(turma.getNomeDisciplina());
	    dados_cabecalho.setPeriodo_letivo(null);
	    dados_cabecalho.setTurma(turma.getCodigo());
	    dados_cabecalho.setCarga_horaria(turma.getcHoraria());
	    mapa.put("cabecalho", dados_cabecalho);
	    
	  //Chama o JasperReport
	    JasperReport report = JasperCompileManager.compileReport(caminho + "/src/br/com/report/rel.jrxml");
	    JasperPrint print = JasperFillManager.fillReport(report, mapa, new JRBeanCollectionDataSource(aluno));
	    JasperExportManager.exportReportToPdfFile(print, dir+"/Lista de presença.pdf");
	}
}
