#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entrypoint.v1;

import org.springframework.data.repository.CrudRepository;

import ${package}.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);
}
