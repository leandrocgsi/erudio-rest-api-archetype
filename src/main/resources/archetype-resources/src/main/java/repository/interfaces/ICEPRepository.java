#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import ${package}.restclient.model.AddressInfo;

public interface ICEPRepository {

	AddressInfo findAddressInfoByCEP(String cep);
	
}