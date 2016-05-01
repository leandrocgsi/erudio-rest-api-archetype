#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.implementations;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ${package}.repository.interfaces.ICEPRepository;
import ${package}.restclient.gateway.AddressInfoGateway;
import ${package}.restclient.model.AddressInfo;

@Repository
public class CEPRepository implements ICEPRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AddressInfoGateway gateway; 

	@Override
	public AddressInfo findAddressInfoByCEP(String cep) {
		return gateway.findAddressInfoByCEP(cep);
	}
}