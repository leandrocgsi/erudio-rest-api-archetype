#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import ${package}.converter.ObjectParser
import ${package}.dto.PagedSearchDTO
import ${package}.model.Person
import ${package}.repository.querybuilder.QueryBuilder
import ${package}.vo.PersonVO

@Repository
@Transactional(readOnly = true)
class PersonPagedSearchRepository<T extends Serializable> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    QueryBuilder<PersonVO> queryBuilder; 

    @PersistenceContext
    private EntityManager entityManager;

    void setParameters(Query query, Map<String, Object> filters) {
        filters.each{ k, v -> (isEmpty(k, v)) ? query.setParameter("${symbol_dollar}{k}", v) : ""}
    }
    
    Boolean isEmpty(String k, Object v) {
        k && v && !v.toString().empty;
    }
    
    Long getTotal(String alias, String entityName, PagedSearchDTO<PersonVO> person) {
        String select = queryBuilder.withDTO(person).getBaseSelectCount(alias, entityName) + queryBuilder.withDTO(person).getWhereAndParameters(alias);
        Query query = entityManager.createQuery(select);
        setParameters(query, person.getFilters());
        (Long)query.getSingleResult();
    }
    
    Query getSearchQuery(String alias, String entityName, PagedSearchDTO<PersonVO> person) {
        String select = queryBuilder.withDTO(person).getHQLQuery(alias, entityName);
        Query query = entityManager.createQuery(select);
        setParameters(query, person.getFilters());
        query.setFirstResult((person.getCurrentPage() - 1) * person.getPageSize());
        query.setMaxResults(person.getPageSize());
        query;
    }
    
    PagedSearchDTO<PersonVO> getPagedSearch(String alias, String entityName, PagedSearchDTO<PersonVO> person) {
        Query searchQuery = getSearchQuery(alias, entityName, person);
		List<Person> persons = searchQuery.getResultList();
		List<PersonVO> personsVO = ObjectParser.parserListObjectInputToObjectOutput(persons, PersonVO.class);
        person.setList(personsVO);
        person.setTotalResults(getTotal(alias, entityName, person).intValue());
        (PagedSearchDTO<PersonVO>) person;
    }
}