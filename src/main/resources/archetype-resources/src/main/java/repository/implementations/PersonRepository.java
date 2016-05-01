#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ${package}.dto.PagedSearchDTO;
import ${package}.model.Person;
import ${package}.repository.PersonPagedSearchRepository;
import ${package}.repository.generic.GenericRepository;
import ${package}.repository.interfaces.IPersonRepository;
import ${package}.vo.PersonVO;


@Repository
public class PersonRepository extends GenericRepository<Person> implements IPersonRepository{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(PersonRepository.class);
	
	@Autowired
	private PersonPagedSearchRepository<Person> personPagedSearchRepository; 
	
	public PersonRepository() {
		super(Person.class);
	}
	
	@Override
	public List<Person> findAll() {
		try {
			List<Person> persons = (List<Person>) entityManager.createNamedQuery("Person.findAllPersons", Person.class).getResultList();
			return persons;
		} catch (PersistenceException e) {
			logger.error(e);
			return new ArrayList<Person>();
		}
	}

	@Override
	public Person findByName(String name) {
		try {
			return entityManager.createNamedQuery("Person.findPersonByName", Person.class).setParameter("name", name).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new Person();
		} 
	}

	@Override
	public Person findById(Integer id) {
		try {
			return entityManager.createNamedQuery("Person.findPersonById", Person.class).setParameter("idPerson", id).getSingleResult();
		} catch (PersistenceException e) {
			logger.error(e);
			return new Person();
		}
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		try {
        	Query query = entityManager.createNamedQuery("Person.deletePersonById").setParameter("idPerson", id);
            query.executeUpdate(); 
        } catch (ConstraintViolationException e) {
            System.out.println("Erro ao alterar status: " + e.getMessage());
            entityManager.getTransaction().rollback();
        } finally {
        	entityManager.close();
        }
	}
	
	public PagedSearchDTO<PersonVO> pagedSearch(PagedSearchDTO<PersonVO> person) {
		try {
			return personPagedSearchRepository.getPagedSearch("p", "Person", person);
		} catch (PersistenceException e) {
			logger.error(e);
			return null;
		}
    }
}