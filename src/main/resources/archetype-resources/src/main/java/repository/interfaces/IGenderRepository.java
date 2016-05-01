#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.Gender;
import ${package}.repository.generic.IGenericRepository;;


public interface IGenderRepository extends IGenericRepository<Gender>{

	List<Gender> findAll();
	
}