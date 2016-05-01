#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import java.util.HashSet;
import java.util.Set;

public class UserVO {

	private Integer id;

	private String name;

	private String login;

	private String password;

	private Set<RoleVO> roles = new HashSet<RoleVO>();

	public UserVO() {
	}

	public UserVO(UserVO user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleVO> roles) {
		this.roles = roles;
	}
}