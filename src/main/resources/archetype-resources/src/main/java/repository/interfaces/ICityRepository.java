#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.City;
import ${package}.repository.generic.IGenericRepository;;


public interface ICityRepository extends IGenericRepository<City>{

	void deleteById(Integer id);
	City findByName(String name);
	City findById(Integer id);
	List<City> findAll();
	
}