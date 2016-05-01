#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.State;
import ${package}.repository.generic.IGenericRepository;;


public interface IStateRepository extends IGenericRepository<State>{

	State findById(Integer id);
	State findByName(String name);
	List<State> findAll();
	
}