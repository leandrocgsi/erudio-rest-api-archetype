#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.interfaces;

import java.util.List;

import ${package}.model.AddressType;
import ${package}.repository.generic.IGenericRepository;;


public interface IAddressTypeRepository extends IGenericRepository<AddressType>{

	AddressType findById(Integer id);
	AddressType findByName(String name);
	List<AddressType> findAll();

}