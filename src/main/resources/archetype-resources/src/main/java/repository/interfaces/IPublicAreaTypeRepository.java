#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.PublicAreaType;
import ${package}.repository.generic.IGenericRepository;;


public interface IPublicAreaTypeRepository extends IGenericRepository<PublicAreaType>{

	PublicAreaType findById(Integer id);
	PublicAreaType findByName(String name);
	List<PublicAreaType> findAll();

}