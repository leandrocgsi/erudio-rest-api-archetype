#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.dto.PagedSearchDTO;
import ${package}.model.Person;
import ${package}.repository.generic.IGenericRepository;
import ${package}.vo.PersonVO;;


public interface IPersonRepository extends IGenericRepository<Person>{

	List<Person> findAll();
	Person findByName(String name);
	Person findById(Integer id);
	void deleteById(Integer id);
	PagedSearchDTO<PersonVO> pagedSearch(PagedSearchDTO<PersonVO> person);
}