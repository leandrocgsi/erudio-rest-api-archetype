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

import ${package}.model.PublicAreaType;
import ${package}.repository.generic.GenericRepository;
import ${package}.repository.interfaces.IPublicAreaTypeRepository;

@Repository
@Transactional(readOnly = true)
public class PublicAreaTypeRepository extends GenericRepository<PublicAreaType> implements IPublicAreaTypeRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(PublicAreaTypeRepository.class);

	public PublicAreaTypeRepository() {
		super(PublicAreaType.class);
	}
	
	@Override
	public PublicAreaType findById(Integer id) {
		try {
			return entityManager.createQuery("select p from PublicAreaType p where p.idPublicAreaType = :idPublicAreaType", PublicAreaType.class).setParameter("idPublicAreaType", id).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new PublicAreaType();
		}
	}
	
	public PublicAreaType findByName(String name) {
		try {
			return entityManager.createQuery("select p from PublicAreaType p where p.publicAreaTypeDescription like :name", PublicAreaType.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new PublicAreaType();
		} 
	}
	
	public List<PublicAreaType> findAll() {
		try {
			return entityManager.createQuery("select p from PublicAreaType p", PublicAreaType.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return new ArrayList<PublicAreaType>();
		}
	}
}