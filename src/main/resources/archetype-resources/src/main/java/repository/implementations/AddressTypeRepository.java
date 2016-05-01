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

import ${package}.model.AddressType;
import ${package}.repository.generic.GenericRepository;
import ${package}.repository.interfaces.IAddressTypeRepository;

@Repository
@Transactional(readOnly = true)
public class AddressTypeRepository extends GenericRepository<AddressType> implements IAddressTypeRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(AddressTypeRepository.class);

	public AddressTypeRepository() {
		super(AddressType.class);
	}
	
	@Override
	public AddressType findById(Integer id) {
		try {
			return entityManager.createQuery("select p from AddressType p where p.idAddressType = :idAddressType", AddressType.class).setParameter("idAddressType", id).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new AddressType();
		}
	}
	
	public AddressType findByName(String name) {
		try {
			return entityManager.createQuery("select p from AddressType p where p.description like :description", AddressType.class).setParameter("description", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new AddressType();
		} 
	}
	
	public List<AddressType> findAll() {
		try {
			return entityManager.createQuery("select p from AddressType p", AddressType.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return new ArrayList<AddressType>();
		}
	}
}