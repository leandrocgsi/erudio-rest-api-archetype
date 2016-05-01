#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.Address;
import ${package}.repository.generic.IGenericRepository;;


public interface IAddressRepository extends IGenericRepository<Address>{

	Address findById(Integer id);
	List<Address> findAll();
	
}