#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ${package}.model.Address;
import ${package}.model.AddressType;
import ${package}.model.City;
import ${package}.model.PublicAreaType;
import ${package}.model.State;
import ${package}.repository.generic.GenericRepository;
import ${package}.repository.interfaces.IAddressRepository;

@Repository
@Transactional(readOnly = true)
public class AddressRepository extends GenericRepository<Address> implements IAddressRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(AddressRepository.class);

	public AddressRepository() {
		super(Address.class);
	}
	
	@Override
	public Address findById(Integer id) {
		try {
			return mockAddress();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		} 
	}
	
	@Override
	public List<Address> findAll() {
		List<Address> addresses = new ArrayList<Address>();
		for (int i = 0; i < 10; i++) {
			addresses.add(mockAddress());
		}
		return addresses ;
	}

	private Address mockAddress() {
		Address mockedAddress = new Address();
		
		AddressType addressType = mockAddressType();
		City city = mockCity();
		PublicAreaType publicAreaType = mockPublicAreaType();
		State state = mockState();
		
		mockedAddress.setAddressType(addressType);
		mockedAddress.setPostalCode("38408-100");
		mockedAddress.setCity(city);
		mockedAddress.setComplement("AP 12345");
		mockedAddress.setIdAddress(1);
		mockedAddress.setNeighborhood("SANTA MÔNICA");
		mockedAddress.setNumber(2121);
		mockedAddress.setPublicAreaType(publicAreaType);
		mockedAddress.setState(state);
		mockedAddress.setStreetName("JOÃO NAVES DE AVILA");
		return mockedAddress;
	}

	private AddressType mockAddressType() {
		AddressType addressType = new AddressType();
		addressType.setIdAddressType(21);
		addressType.setDescription("RESIDENTIAL");
		return addressType;
	}

	private PublicAreaType mockPublicAreaType() {
		PublicAreaType publicAreaType = new PublicAreaType();
		publicAreaType.setIdPublicAreaType(545);
		publicAreaType.setPublicAreaTypeDescription("STREET");
		return publicAreaType;
	}

	private State mockState() {
		State state = new State();
		state.setIdState(897);
		state.setStateName("MINAS GERAIS");
		return state;
	}

	private City mockCity() {
		City city = new City();
		city.setIdCity(123);
		city.setName("UBERLÂNDIA");
		return city;
	}
}