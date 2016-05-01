#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.reporter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.File;

import ${package}.fakedata.DataBean;
import ${package}.fakedata.DataBeanMaker;
import ${package}.utils.FileUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository
class Reporter {
        
	private Logger logger = Logger.getLogger(Reporter.class);
	
    def makeReport() throws Exception {

    	FileUtils fileUtils = new FileUtils()
	
    	DataBeanMaker dataBeanMaker = new DataBeanMaker();
		InputStream inputStream = getClass().getResourceAsStream("template/test_jasper.jrxml");
        
        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		Map parameters = new HashMap();
		File pdf = File.createTempFile("output.", ".pdf");
        try {
			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
		} catch (Exception e) {
			logger.error(e);
		}
        byte[] array = fileUtils.getBytesFromFile(pdf);
    }
}