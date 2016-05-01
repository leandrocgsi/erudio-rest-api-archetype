#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.implementations;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ${package}.repository.interfaces.IReportRepository;
import ${package}.service.reporter.Reporter;

@Repository
public class ReportRepository implements IReportRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Reporter reporter; 

	@Override
	public byte[] makeReport() throws Exception {
		return (byte[])reporter.makeReport();
	}
}