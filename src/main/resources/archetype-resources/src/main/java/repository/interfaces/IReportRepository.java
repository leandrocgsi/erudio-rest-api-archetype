#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

public interface IReportRepository {

	byte[] makeReport () throws Exception;
	
}