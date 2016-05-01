#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils.email;

public class EMailConfigs {
	
	String hostname;
	String username;
	String password;
	String from;
	int port;
	boolean ssl;
	String subject;
	String message;
}