#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.implementations;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ${package}.model.City;
import ${package}.repository.generic.GenericRepository;
import ${package}.repository.interfaces.ICityRepository;

@Repository
@Transactional(readOnly = true)
public class CityRepository extends GenericRepository<City> implements ICityRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(CityRepository.class);

	public CityRepository() {
		super(City.class);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
        try {
        	Query query = entityManager.createNamedQuery("City.deleteCityById").setParameter("idCity", id);
            query.executeUpdate(); 
        } catch (ConstraintViolationException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
        	entityManager.close();
        }
	}	
		
	public City findByName(String name) {
		try {
			return entityManager.createNamedQuery("City.findCityByName", City.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		} 
	}
	
	public City findById(Integer idCity) {
		try {
			return entityManager.createNamedQuery("City.findCityById", City.class).setParameter("idCity", idCity).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		}
	}
	
	public List<City> findAll() {
		try {
			return (List<City>) entityManager.createNamedQuery("City.findAllCities", City.class).getResultList();
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		}
	}
}